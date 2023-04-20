package codegenerator;

import ast.Program;
import ast.definition.Definition;
import ast.definition.FunctionDefinition;
import ast.definition.VariableDefinition;
import ast.expression.Expression;
import ast.statement.Assignment;
import ast.statement.Print;
import ast.statement.Read;
import ast.statement.Statement;
import ast.type.FunctionType;
import ast.type.VoidType;

import java.util.List;
import java.util.stream.Collectors;

public class ExecuteCGVisitor extends AbstractCGVisitor<Void, Void>{

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
    public Void visit(Program program, Void param) {
        for(Definition definition: program.definitions) {
            if(definition instanceof VariableDefinition) {
                definition.accept(this, param);
            }
        }
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
    public Void visit(Read read, Void param) {
        for(Expression expression: read.expressions) {
            expression.accept(addressCGVisitor, param);
            cg.in(expression.getType());
            cg.store(expression.getType());
        }

        return null;
    }

    /**
     * execute[[Print : statement-> expression*]]() =
     *
     * value[[expression]]()
     * <out> expression.type.suffix()
     */
    @Override
    public Void visit(Print print, Void param) {
        for (Expression expression: print.expressions) {
            expression.accept(valueCGVisitor, param);
            cg.out(expression.getType());
        }
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
    public Void visit(Assignment assignment, Void param) {

        assignment.leftExpression.accept(addressCGVisitor, param);
        assignment.rightExpression.accept(valueCGVisitor, param);
        cg.store(assignment.leftExpression.getType());
        return null;
    }

    /**
     * execute[[VariableDefinition: definition -> type ID]]() =
     *
     * <' * > type definition.getName() <(offset: > definition.offset <)>
     */
    @Override
    public Void visit(VariableDefinition variableDefinition, Void param) {

        cg.addComment(" * " + variableDefinition.getType().toString()
                + " " + variableDefinition.getName() + "(offset: " + variableDefinition.getOffset() + ")");
        return null;
    }


    /**
     * execute[[FunctionDefinition : definition -> type ID variableDefinition* statement*]]() =
     *
     *   <ID:>
     *
     *   <' * Local variables: >
     *   variableDefinition*.forEach( varDef -> { execute[[varDef]] });
     *   int byteLocals = variableDefinition*.isEmpty() ? 0 : variableDefinition*.get(variableDefinition*.size() -1).offset
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
    public Void visit(FunctionDefinition functionDefinition, Void param) {
        List<Statement> statements = functionDefinition.statements
                .stream()
                .filter(statement -> !(statement instanceof VariableDefinition))
                .collect(Collectors.toList());
        List<Statement> variableDefinitions = functionDefinition.statements
                .stream()
                .filter(statement -> statement instanceof VariableDefinition)
                .collect(Collectors.toList());

        cg.label(functionDefinition.getName());

        cg.addComment(" * " + "Local variables:" + "\n");

        variableDefinitions.forEach(statement -> statement.accept(this, param));

        int byteLocals = variableDefinitions.isEmpty() ?
                0
                :
                ((VariableDefinition)variableDefinitions.get(variableDefinitions.size() - 1)).getOffset();


        cg.enter(byteLocals);

        int byteParameters = ((FunctionType) functionDefinition.getType()).parameters
                .stream()
                .map(p -> p.getType())
                .mapToInt(type -> type.numberOfBytes())
                .sum();

        int bytesReturn = ((FunctionType) functionDefinition.getType()).returnType.numberOfBytes();

        statements.forEach(statement -> statement.accept(this, param));

        if(((FunctionType)functionDefinition.getType()).returnType == VoidType.getInstance()) {
            cg.ret(bytesReturn, byteLocals, byteParameters);
        }
        return null;
    }
}
