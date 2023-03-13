package visitor;

import ast.Program;
import ast.definition.FunctionDefinition;
import ast.definition.VariableDefinition;
import ast.expression.*;
import ast.statement.*;
import ast.type.*;

public class AbstractVisitor<TP, TR> implements Visitor <TP,TR>{

    @Override
    public TR visit(Program program, TP param) {
        program.definitions.forEach(def -> def.accept(this, null));
        return null;
    }

    @Override
    public TR visit(FunctionDefinition functionDefinition, TP param) {
        functionDefinition.statements.forEach(stmt -> stmt.accept(this, null));
        functionDefinition.getType().accept(this, null);
        return null;
    }

    @Override
    public TR visit(VariableDefinition variableDefinition, TP param) {
        variableDefinition.getType().accept(this, null);
        return null;
    }

    @Override
    public TR visit(Arithmetic arithmetic, TP param) {
        arithmetic.leftExpression.accept(this, null);
        arithmetic.rightExpression.accept(this, null);
        return null;
    }

    @Override
    public TR visit(ArrayAccess arrayAccess, TP param) {
        arrayAccess.leftExpression.accept(this, null);
        arrayAccess.rightExpression.accept(this, null);
        return null;
    }

    @Override
    public TR visit(Cast cast, TP param) {
        cast.expression.accept(this, null);
        return null;
    }

    @Override
    public TR visit(CharLiteral charLiteral, TP param) {
        return null;
    }

    @Override
    public TR visit(Comparison comparison, TP param) {
        comparison.leftExpression.accept(this, null);
        comparison.rightExpression.accept(this, null);
        return null;
    }

    @Override
    public TR visit(FieldAccess fieldAccess, TP param) {
        fieldAccess.expression.accept(this, null);
        return null;
    }

    @Override
    public TR visit(FunctionInvocation functionInvocation, TP param) {
        functionInvocation.arguments.forEach(exp -> exp.accept(this, null));
        functionInvocation.variable.accept(this, null);
        return null;
    }

    @Override
    public TR visit(IntLiteral intLiteral, TP param) {
        return null;
    }

    @Override
    public TR visit(Logical logical, TP param) {
        logical.leftExpression.accept(this, null);
        logical.rightExpression.accept(this, null);
        return null;
    }

    @Override
    public TR visit(Not not, TP param) {
        not.expression.accept(this, null);
        return null;
    }

    @Override
    public TR visit(RealLiteral realLiteral, TP param) {
        return null;
    }

    @Override
    public TR visit(UnaryMinus unaryMinus, TP param) {
        unaryMinus.expression.accept(this, null);
        return null;
    }

    @Override
    public TR visit(Variable variable, TP param) {
        return null;
    }

    @Override
    public TR visit(Assignment assignment, TP param) {
        assignment.leftExpression.accept(this, null);
        assignment.rightExpression.accept(this, null);
        return null;
    }

    @Override
    public TR visit(IfElse ifElse, TP param) {
        ifElse.expression.accept(this, null);
        ifElse.ifStatements.forEach(stmt -> stmt.accept(this, null));
        ifElse.elseStatements.forEach(stmt -> stmt.accept(this, null));
        return null;
    }

    @Override
    public TR visit(Print print, TP param) {
        print.expressions.forEach(exp -> exp.accept(this, null));
        return null;
    }

    @Override
    public TR visit(Read read, TP param) {
        read.expressions.forEach(exp -> exp.accept(this, null));
        return null;
    }

    @Override
    public TR visit(Return aReturn, TP param) {
        aReturn.expression.accept(this, null);
        return null;
    }

    @Override
    public TR visit(While aWhile, TP param) {
        aWhile.expression.accept(this, null);
        aWhile.statements.forEach(stmt -> stmt.accept(this, null));
        return null;
    }

    @Override
    public TR visit(ArrayType arrayType, TP param) {
        arrayType.type.accept(this, null);
        return null;
    }

    @Override
    public TR visit(CharType charType, TP param) {
        return null;
    }

    @Override
    public TR visit(ErrorType errorType, TP param) {
        return null;
    }

    @Override
    public TR visit(FunctionType functionType, TP param) {
        functionType.parameters.forEach(varDef -> varDef.accept(this, null));
        functionType.returnType.accept(this, null);
        return null;
    }

    @Override
    public TR visit(IntType intType, TP param) {
        return null;
    }

    @Override
    public TR visit(RealType realType, TP param) {
        return null;
    }

    @Override
    public TR visit(RecordField recordField, TP param) {
        recordField.type.accept(this, null);
        return null;
    }

    @Override
    public TR visit(RecordType recordType, TP param) {
        recordType.recordFields.forEach(recordField -> recordField.accept(this, null));
        return null;
    }

    @Override
    public TR visit(VoidType voidType, TP param) {
        return null;
    }
}
