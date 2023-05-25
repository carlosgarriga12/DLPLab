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
        throw new RuntimeException("This method should not be reached -> PROGRAM");
    }

    @Override
    public TR visit(FunctionDefinition functionDefinition, TP param) {
        throw new RuntimeException("This method should not be reached -> FUNCTION DEFINITION");
    }

    @Override
    public TR visit(VariableDefinition variableDefinition, TP param) {
        throw new RuntimeException("This method should not be reached -> VARIABLE DEFINITION");
    }

    @Override
    public TR visit(Arithmetic arithmetic, TP param) {
        throw new RuntimeException("This method should not be reached -> ARITHMETIC");
    }

    @Override
    public TR visit(ArrayAccess arrayAccess, TP param) {
        throw new RuntimeException("This method should not be reached -> ARRAY ACCESS");
    }

    @Override
    public TR visit(Cast cast, TP param) {
        throw new RuntimeException("This method should not be reached -> CAST");
    }

    @Override
    public TR visit(CharLiteral charLiteral, TP param) {
        throw new RuntimeException("This method should not be reached -> CHAR_LITERAL");
    }

    @Override
    public TR visit(Comparison comparison, TP param) {
        throw new RuntimeException("This method should not be reached -> COMPARISON");
    }

    @Override
    public TR visit(FieldAccess fieldAccess, TP param) {
        throw new RuntimeException("This method should not be reached -> FIELD_ACCESS");
    }

    @Override
    public TR visit(FunctionInvocation functionInvocation, TP param) {
        throw new RuntimeException("This method should not be reached -> FUNCTION_INVOCATION");
    }

    @Override
    public TR visit(IntLiteral intLiteral, TP param) {
        throw new RuntimeException("This method should not be reached -> INT_LITERAL");
    }

    @Override
    public TR visit(Logical logical, TP param) {
        throw new RuntimeException("This method should not be reached -> LOGICAL");
    }

    @Override
    public TR visit(Not not, TP param) {
        throw new RuntimeException("This method should not be reached -> NOT");
    }

    @Override
    public TR visit(RealLiteral realLiteral, TP param) {
        throw new RuntimeException("This method should not be reached -> REAL_LITERAL");
    }

    @Override
    public TR visit(UnaryMinus unaryMinus, TP param) {
        throw new RuntimeException("This method should not be reached -> UNARY_MINUS");
    }

    @Override
    public TR visit(Variable variable, TP param) {
        throw new RuntimeException("This method should not be reached -> VARIABLE");
    }

    @Override
    public TR visit(Assignment assignment, TP param) {
        throw new RuntimeException("This method should not be reached -> ASSIGNMENT");
    }

    @Override
    public TR visit(IfElse ifElse, TP param) {
        throw new RuntimeException("This method should not be reached -> IF_ELSE");
    }

    @Override
    public TR visit(Print print, TP param) {
        throw new RuntimeException("This method should not be reached -> PRINT");
    }

    @Override
    public TR visit(Read read, TP param) {
        throw new RuntimeException("This method should not be reached -> READ");
    }

    @Override
    public TR visit(Return aReturn, TP param) {
        throw new RuntimeException("This method should not be reached -> RETURN");
    }

    @Override
    public TR visit(While aWhile, TP param) {
        throw new RuntimeException("This method should not be reached -> WHILE");
    }

    @Override
    public TR visit(ArrayType arrayType, TP param) {
        throw new RuntimeException("This method should not be reached -> ARRAY_TYPE");
    }

    @Override
    public TR visit(CharType charType, TP param) {
        throw new RuntimeException("This method should not be reached -> CHAR_TYPE");
    }

    @Override
    public TR visit(ErrorType errorType, TP param) {
        throw new RuntimeException("This method should not be reached -> ERROR_TYPE");
    }

    @Override
    public TR visit(FunctionType functionType, TP param) {
        throw new RuntimeException("This method should not be reached -> FUNCTION_TYPE");
    }

    @Override
    public TR visit(IntType intType, TP param) {
        throw new RuntimeException("This method should not be reached -> INT_TYPE");
    }

    @Override
    public TR visit(RealType realType, TP param) {
        throw new RuntimeException("This method should not be reached -> REAL_TYPE");
    }

    @Override
    public TR visit(RecordField recordField, TP param) {
        throw new RuntimeException("This method should not be reached -> RECORD_FIELD");
    }

    @Override
    public TR visit(RecordType recordType, TP param) {
        throw new RuntimeException("This method should not be reached -> RECORD_TYPE");
    }

    @Override
    public TR visit(VoidType voidType, TP param) {
        throw new RuntimeException("This method should not be reached -> VOID_TYPE");
    }
}
