package codegenerator;

import ast.Program;
import ast.definition.Definition;
import ast.definition.FunctionDefinition;
import ast.definition.VariableDefinition;
import ast.expression.Expression;
import ast.expression.FunctionInvocation;
import ast.statement.*;
import ast.type.FunctionType;
import ast.type.VoidType;

import java.util.List;
import java.util.stream.Collectors;

public class ExecuteCGVisitor extends AbstractCGVisitor<Object, Void>{

    private CodeGenerator cg;
    private AddressCGVisitor addressCGVisitor;
    private ValueCGVisitor valueCGVisitor;

    public ExecuteCGVisitor(CodeGenerator codeGenerator) {
        this.cg = codeGenerator;
        this.valueCGVisitor = new ValueCGVisitor(cg);
        this.addressCGVisitor = new AddressCGVisitor(cg);

        this.valueCGVisitor.setAddressCGVisitor(addressCGVisitor);
        this.addressCGVisitor.setValueCGVisitor(valueCGVisitor);
    }

    /**
     * execute[[Program: program -> definition*]]() =
     *
     * for(Definition definition: definition*)
     *      if(def instanceof VarDefinition)
     *              execute[[def]]()
     * <call main>
     * <halt>
     * for(Definition definition: definition*)
     *      if(def instanceof FuncDefinition)
     *              execute[[def]]()
     */
    @Override
    public Void visit(Program program, Object param) {
        for(Definition definition: program.definitions) {
            if(definition instanceof VariableDefinition) {
                definition.accept(this, param);
            }
        }
        cg.newLine();
        cg.mainProgram();
        for(Definition definition: program.definitions) {
            if(definition instanceof FunctionDefinition) {
                definition.accept(this, param);
            }
        }
        return null;
    }

    /**
     * execute[[Read: statement -> expression*]]() =
     *
     * address[[expression]]()
     * <in> expression.type.suffix()
     * <store> expression.type.suffix()
     */
    @Override
    public Void visit(Read read, Object param) {
        cg.writeLine(read.getLine());
        cg.addComment(" * Read");
        for(Expression expression: read.expressions) {
            expression.accept(addressCGVisitor, param);
            cg.in(expression.getType());
            cg.store(expression.getType());
        }

        cg.newLine();
        return null;
    }

    /**
     * execute[[Print : statement-> expression*]]() =
     *
     * value[[expression]]()
     * <out> expression.type.suffix()
     */
    @Override
    public Void visit(Print print, Object param) {
        for (Expression expression: print.expressions) {
            cg.writeLine(print.getLine());
            cg.addComment(" * Write");
            expression.accept(valueCGVisitor, param);
            cg.out(expression.getType());
        }
        cg.newLine();
        return null;
    }

    /**
     * execute[[Assignment: statement -> expression1 expression2]]() =
     *
     * address[[expression1]]
     * value[[expression2]]
     * <store> expression1.type.suffix()
     */
    @Override
    public Void visit(Assignment assignment, Object param) {
        cg.writeLine(assignment.getLine());
        cg.addComment(" * Assignment");
        assignment.leftExpression.accept(addressCGVisitor, param);
        assignment.rightExpression.accept(valueCGVisitor, param);
        cg.store(assignment.leftExpression.getType());
        cg.newLine();
        return null;
    }

    /**
     * execute[[VariableDefinition: definition -> type ID]]() =
     *
     * <' * > type definition.getName() <(offset: > definition.offset <)>
     */
    @Override
    public Void visit(VariableDefinition variableDefinition, Object param) {

        cg.addComment(" * " + variableDefinition.getType().toString()
                + " " + variableDefinition.getName() + "(offset: " + variableDefinition.getOffset() + ")");
        return null;
    }


    /**
     * execute[[FunctionDefinition : definition -> type ID variableDefinition* statement*]]() =
     *
     *   <ID:>
     *   <' * Parameters: >
     *   variableDefinition*.stream().forEach(vd -> execute[[vd]]);
     *
     *   <' * Local variables: >
     *   variableDefinition*.forEach( varDef -> { execute[[varDef]] });
     *   int byteLocals = variableDefinition*.isEmpty() ? 0 : -variableDefinition*.get(variableDefinition*.size() -1).offset
     *
     *   <enter > byteLocals
     *
     *   int bytesParameters = 0;
     *   for(VariableDefinition varDef : type.parameters){
     *       bytesParameters += def.type.numberOfBytes();
     *   }
     *
     *   int bytesReturn = type.returnType.numberOfBytes();
     *
     *   statement*.forEach(stmt -> { execute[[stmt]] })
     *
     *   if(type.getReturningType().equals( Void.getInstance() )){
     *       <ret > bytesReturn , bytesLocals , bytesParams
     *   }
     *
     */
    @Override
    public Void visit(FunctionDefinition functionDefinition, Object param) {
        List<Statement> statements = functionDefinition.statements
                .stream()
                .filter(statement -> !(statement instanceof VariableDefinition))
                .collect(Collectors.toList());
        List<Statement> variableDefinitions = functionDefinition.statements
                .stream()
                .filter(statement -> statement instanceof VariableDefinition)
                .collect(Collectors.toList());

        cg.writeLine(functionDefinition.getLine());
        cg.newLine();
        cg.label(functionDefinition.getName());
        cg.addComment(" * " + "Parameters:");
        functionDefinition.parameters.stream().forEach(vd -> vd.accept(this, param));
        cg.addComment(" * " + "Local variables:");
        variableDefinitions.forEach(statement -> statement.accept(this, param));

        int byteLocals = variableDefinitions.isEmpty() ?
                0
                :
                -((VariableDefinition)variableDefinitions.get(variableDefinitions.size() - 1)).getOffset();
        boolean isVoid = ((FunctionType)functionDefinition.getType()).returnType == VoidType.getInstance();

        cg.enter(byteLocals);
        if(isVoid) {
            cg.newLine();
        }
        int byteParameters = ((FunctionType) functionDefinition.getType()).parameters
                .stream()
                .map(p -> p.getType())
                .mapToInt(type -> type.numberOfBytes())
                .sum();

        int bytesReturn = ((FunctionType) functionDefinition.getType()).returnType.numberOfBytes();

        statements.forEach(statement -> statement.accept(this, functionDefinition));

        if(isVoid) {
            cg.ret(bytesReturn, byteLocals, byteParameters);
        }
        cg.newLine();
        return null;
    }

    /**
     * execute[[While: statement -> expression statement*]]() =
     *
     *  int conditionLabel = cg.nextLabel();
     *  int exitLabel = cg.nextLabel();
     *
     *  <label> conditionLabel <:>
     *  value[[expression]]
     *  <jz label> exitLabel
     *  statement*.stream().forEach(execute[[statement]]);
     *  <jmp label> conditionLabel
     *  <label> exitLabel <:>
     *
     */
    @Override
    public Void visit(While aWhile, Object param) {
        cg.writeLine(aWhile.getLine());
        cg.addComment(" * While");
        int conditionLabel = cg.nextLabel();
        int exitLabel = cg.nextLabel();

        cg.putLabel(conditionLabel);
        aWhile.expression.accept(valueCGVisitor, null);
        cg.jumpIfZero(exitLabel);
        cg.addComment(" * While body");
        cg.newLine();
        aWhile.statements.stream().forEach(st -> st.accept(this, param));
        cg.jump(conditionLabel);
        cg.putLabel(exitLabel);
        cg.newLine();
        return null;
    }

    /**
     * execute[[IfElse: statement -> expression statement1* statement2*]]() =
     *
     * int elseLabel = cg.nextLabel()
     * int exitLabel = cg.nextLabel()
     *
     * value[[expression]]()
     * <jz label> elseLabel
     * statement1*.stream().forEach(st -> execute[[st]])
     * <jmp label> exitLabel
     * <label> elseLabel <:>
     * statement2*.stream().forEach(st -> execute[[st]])
     * <label> exitLabel <:>
     *
     */
    @Override
    public Void visit(IfElse ifElse, Object param) {
        cg.writeLine(ifElse.getLine());
        cg.addComment(" * IfElse");
        int elseLabel = cg.nextLabel();
        int exitLabel = cg.nextLabel();

        ifElse.expression.accept(valueCGVisitor, param);
        cg.jumpIfZero(elseLabel);
        ifElse.ifStatements.stream().forEach(st -> st.accept(this, param));
        cg.jump(exitLabel);
        cg.putLabel(elseLabel);
        ifElse.elseStatements.stream().forEach(st -> st.accept(this, param));
        cg.putLabel(exitLabel);

        return null;
    }

    /**
     * execute[[Invocation : statement -> expression2 expression3*]]()
     *
     * value[[(Expression) statement]]()
     *
     * if(!((Expression) statement).type instanceof VoidType) {
     *     <pop> ((Expression)statement).type.suffix()
     * }
     */
    @Override
    public Void visit(FunctionInvocation functionInvocation, Object param) {
        cg.writeLine(functionInvocation.getLine());
        functionInvocation.accept(valueCGVisitor, param);

        if(!(functionInvocation.type instanceof VoidType)) {
            cg.pop(functionInvocation.type.suffix());
        }
        cg.newLine();
        return null;
    }

    /**
     * execute[[Return : statement -> expression]](funcDefinition) =
     *
     * value[[expression]]()
     *
     * <ret >
     *     funcDefinition.type.returnType.numberOfBytes <, >
     *     funcDefinition.byteLocalsSum <, >
     *     funcDefinition.type.byteParamSum
     */
    @Override
    public Void visit(Return aReturn, Object param) {
        cg.addComment(" * Return");
        aReturn.expression.accept(valueCGVisitor, param);
        FunctionDefinition functionDefinition = (FunctionDefinition) param;

        int bytesLocal = functionDefinition.statements
                .stream()
                .filter(st -> st instanceof VariableDefinition)
                .mapToInt(vd -> ((VariableDefinition) vd).getType().numberOfBytes())
                .sum();

        int byteParameters = ((FunctionType) functionDefinition.getType()).parameters
                .stream()
                .map(p -> p.getType())
                .mapToInt(type -> type.numberOfBytes())
                .sum();
        cg.ret(
                aReturn.expression.getType().numberOfBytes(),
                bytesLocal,
                byteParameters
        );
        return null;
    }
}
