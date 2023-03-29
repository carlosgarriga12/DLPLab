package semantic;

import ast.definition.FunctionDefinition;
import ast.expression.*;
import ast.statement.*;
import ast.type.*;
import visitor.AbstractVisitor;

public class TypeCheckingVisitor extends AbstractVisitor<Type, Void> {

    @Override
    public Void visit(Arithmetic arithmetic, Type param) {
        super.visit(arithmetic, null);
        arithmetic.setlValue(false);
        arithmetic.setType(
                arithmetic.leftExpression.getType().
                        arithmetic(arithmetic.rightExpression.getType(),arithmetic));
        return null;
    }

    @Override
    public Void visit(ArrayAccess arrayAccess, Type param) {
        super.visit(arrayAccess, null);
        arrayAccess.setlValue(true);
        arrayAccess.setType(
                arrayAccess.leftExpression.getType().
                squareBrackets(arrayAccess.rightExpression.getType(), arrayAccess));
        return null;
    }

    @Override
    public Void visit(Cast cast, Type param) {
        super.visit(cast, null);
        cast.setlValue(false);
        cast.setType(
                cast.expression.getType().cast(cast.castType, cast));
        return null;
    }

    @Override
    public Void visit(CharLiteral charLiteral, Type param) {
        super.visit(charLiteral, null);
        charLiteral.setlValue(false);
        charLiteral.setType(CharType.getInstance());
        return null;
    }

    @Override
    public Void visit(Comparison comparison, Type param) {
        super.visit(comparison, null);
        comparison.setlValue(false);
        comparison.setType(
                comparison.leftExpression.getType().
                comparison(comparison.rightExpression.getType(), comparison));
        return null;
    }

    @Override
    public Void visit(FieldAccess fieldAccess, Type param) {
        super.visit(fieldAccess, null);
        fieldAccess.setlValue(true);
        fieldAccess.setType(fieldAccess.expression.getType().
                dot(fieldAccess.fieldName, fieldAccess));
        return null;
    }

    @Override
    public Void visit(FunctionInvocation functionInvocation, Type param) {
        super.visit(functionInvocation, null);
        functionInvocation.setlValue(false);
        functionInvocation.setType(functionInvocation.variable.getType().
                parenthesis(functionInvocation.arguments
                        .stream()
                        .map(exp -> exp.getType()).toList(), functionInvocation));
        return null;
    }

    @Override
    public Void visit(IntLiteral intLiteral, Type param) {
        super.visit(intLiteral, null);
        intLiteral.setlValue(false);
        intLiteral.setType(IntType.getInstance());
        return null;
    }

    @Override
    public Void visit(Logical logical, Type param) {
        super.visit(logical, null);
        logical.setlValue(false);
        logical.setType(logical.leftExpression.getType().
                logical(logical.rightExpression.getType(), logical));
        return null;
    }

    @Override
    public Void visit(Not not, Type param) {
        super.visit(not, null);
        not.setlValue(false);
        not.setType(not.expression.getType().not(not));
        return null;
    }

    @Override
    public Void visit(RealLiteral realLiteral, Type param) {
        super.visit(realLiteral, null);
        realLiteral.setlValue(false);
        realLiteral.setType(RealType.getInstance());
        return null;
    }

    @Override
    public Void visit(UnaryMinus unaryMinus, Type param) {
        super.visit(unaryMinus, null);
        unaryMinus.setlValue(false);
        unaryMinus.setType(unaryMinus.expression.getType().unaryMinus(unaryMinus));
        return null;
    }

    @Override
    public Void visit(Variable variable, Type param) {
        super.visit(variable, null);
        variable.setlValue(true);
        variable.setType(variable.definition.getType());
        return null;
    }

    @Override
    public Void visit(Assignment assignment, Type param) {
        super.visit(assignment, null);
        if (!assignment.leftExpression.islValue()) {
            new ErrorType(
                    assignment.leftExpression.getLine(),
                    assignment.leftExpression.getColumn(),
                    "The expression on the left part of the assignment is not lValue"
            );
        }
        assignment.leftExpression.getType().assignment(assignment.rightExpression.getType(), assignment);

        return null;
    }

    @Override
    public Void visit(Read read, Type param) {
        super.visit(read, null);
        read.expressions.forEach(exp -> {
            if (!exp.islValue()) {
                new ErrorType(
                        exp.getLine(),
                        exp.getColumn(),
                        "The expression on the read statement is not lValue");
            }
        });
        return null;
    }

    @Override
    public Void visit(IfElse ifElse, Type param) {
        super.visit(ifElse, null);
        ifElse.expression.getType().asLogical(ifElse.expression.getType(), ifElse);
        return null;
    }

    @Override
    public Void visit(While aWhile, Type param) {
        super.visit(aWhile, null);
        aWhile.expression.getType().asLogical(aWhile.expression.getType(), aWhile);
        return null;
    }

    @Override
    public Void visit(FunctionDefinition functionDefinition, Type param) {
        functionDefinition.statements.forEach(stmt -> stmt.accept(this, ((FunctionType)functionDefinition.getType())
                .returnType));
        functionDefinition.getType().accept(this, null);
        if(((FunctionType)functionDefinition.getType()).returnType instanceof VoidType) {
            functionDefinition.statements.stream().forEach(st -> {
                if(st instanceof Return) {
                    new ErrorType(
                            st.getLine(),
                            st.getColumn(),
                            "Return statement in Void function");
                }
            });
        } else {

        }
        return null;
    }

    @Override
    public Void visit(Return aReturn, Type param) {
        super.visit(aReturn, null);
        if(!aReturn.expression.getType().mustBeSubtype(param, aReturn) && !(param instanceof VoidType)) {
            new ErrorType(
                    aReturn.getLine(),
                    aReturn.getColumn(),
                    String.format("Return statement is returning " +
                            "an expression of type %s that is not a " +
                            "subtype of the return type %s", aReturn.expression.getType(), param));
        }
        return null;
    }
}
