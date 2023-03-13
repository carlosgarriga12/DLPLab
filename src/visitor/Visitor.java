package visitor;

import ast.Program;
import ast.definition.FunctionDefinition;
import ast.definition.VariableDefinition;
import ast.expression.*;
import ast.statement.*;
import ast.type.*;

public interface Visitor<TP, TR> {
    //Program
    TR visit(Program program, TP param);

    //Definitions
    TR visit (FunctionDefinition functionDefinition, TP param);
    TR visit (VariableDefinition variableDefinition, TP param);

    //Expressions
    TR visit(Arithmetic arithmetic, TP param);
    TR visit(ArrayAccess arrayAccess, TP param);
    TR visit(Cast cast, TP param);
    TR visit(CharLiteral charLiteral, TP param);
    TR visit(Comparison comparison, TP param);
    TR visit(FieldAccess fieldAccess, TP param);
    TR visit(FunctionInvocation functionInvocation, TP param);
    TR visit(IntLiteral intLiteral, TP param);
    TR visit(Logical logical, TP param);
    TR visit(Not not, TP param);
    TR visit(RealLiteral realLiteral, TP param);
    TR visit(UnaryMinus unaryMinus, TP param);
    TR visit(Variable variable, TP param);

    //Statements
    TR visit(Assignment assignment, TP param);
    TR visit(IfElse ifElse, TP param);
    TR visit(Print print, TP param);
    TR visit(Read read, TP param);
    TR visit(Return aReturn, TP param);
    TR visit(While aWhile, TP param);

    //Types
    TR visit(ArrayType arrayType, TP param);
    TR visit(CharType charType, TP param);
    TR visit(ErrorType errorType, TP param);
    TR visit(FunctionType functionType, TP param);
    TR visit(IntType intType, TP param);
    TR visit(RealType realType, TP param);
    TR visit(RecordField recordField, TP param);
    TR visit(RecordType recordType, TP param);
    TR visit(VoidType voidType, TP param);
}
