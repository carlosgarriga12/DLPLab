package codegenerator;

import ast.Program;
import ast.definition.FunctionDefinition;
import ast.definition.VariableDefinition;
import ast.expression.*;
import ast.statement.*;
import ast.type.*;
import visitor.Visitor;

public class AbstractCGVisitor<TP, TR> implements Visitor<TP, TR> {

    @Override
    public TR visit(Program program, TP param) {
        return null;
    }

    @Override
    public TR visit(FunctionDefinition functionDefinition, TP param) {
        return null;
    }

    @Override
    public TR visit(VariableDefinition variableDefinition, TP param) {
        return null;
    }

    @Override
    public TR visit(Arithmetic arithmetic, TP param) {
        return null;
    }

    @Override
    public TR visit(ArrayAccess arrayAccess, TP param) {
        return null;
    }

    @Override
    public TR visit(Cast cast, TP param) {
        return null;
    }

    @Override
    public TR visit(CharLiteral charLiteral, TP param) {
        return null;
    }

    @Override
    public TR visit(Comparison comparison, TP param) {
        return null;
    }

    @Override
    public TR visit(FieldAccess fieldAccess, TP param) {
        return null;
    }

    @Override
    public TR visit(FunctionInvocation functionInvocation, TP param) {
        return null;
    }

    @Override
    public TR visit(IntLiteral intLiteral, TP param) {
        return null;
    }

    @Override
    public TR visit(Logical logical, TP param) {
        return null;
    }

    @Override
    public TR visit(Not not, TP param) {
        return null;
    }

    @Override
    public TR visit(RealLiteral realLiteral, TP param) {
        return null;
    }

    @Override
    public TR visit(UnaryMinus unaryMinus, TP param) {
        return null;
    }

    @Override
    public TR visit(Variable variable, TP param) {
        return null;
    }

    @Override
    public TR visit(Assignment assignment, TP param) {
        return null;
    }

    @Override
    public TR visit(IfElse ifElse, TP param) {
        return null;
    }

    @Override
    public TR visit(Print print, TP param) {
        return null;
    }

    @Override
    public TR visit(Read read, TP param) {
        return null;
    }

    @Override
    public TR visit(Return aReturn, TP param) {
        return null;
    }

    @Override
    public TR visit(While aWhile, TP param) {
        return null;
    }

    @Override
    public TR visit(ArrayType arrayType, TP param) {
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
        return null;
    }

    @Override
    public TR visit(RecordType recordType, TP param) {
        return null;
    }

    @Override
    public TR visit(VoidType voidType, TP param) {
        return null;
    }
}
