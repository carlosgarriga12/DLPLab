package semantic;

import ast.expression.*;
import ast.statement.*;
import ast.type.ErrorType;
import visitor.AbstractVisitor;

public class TypeCheckingVisitor extends AbstractVisitor<Void, Void> {

    @Override
    public Void visit(Arithmetic arithmetic, Void param) {
        super.visit(arithmetic, null);
        arithmetic.setlValue(false);
        return null;
    }

    @Override
    public Void visit(ArrayAccess arrayAccess, Void param) {
        super.visit(arrayAccess, null);
        arrayAccess.setlValue(true);
        return null;
    }

    @Override
    public Void visit(Cast cast, Void param) {
        super.visit(cast, null);
        cast.setlValue(false);
        return null;
    }

    @Override
    public Void visit(CharLiteral charLiteral, Void param) {
        super.visit(charLiteral, null);
        charLiteral.setlValue(false);
        return null;
    }

    @Override
    public Void visit(Comparison comparison, Void param) {
        super.visit(comparison, null);
        comparison.setlValue(false);
        return null;
    }

    @Override
    public Void visit(FieldAccess fieldAccess, Void param) {
        super.visit(fieldAccess, null);
        fieldAccess.setlValue(true);
        return null;
    }

    @Override
    public Void visit(FunctionInvocation functionInvocation, Void param) {
        super.visit(functionInvocation, null);
        functionInvocation.setlValue(false);
        return null;
    }

    @Override
    public Void visit(IntLiteral intLiteral, Void param) {
        super.visit(intLiteral, null);
        intLiteral.setlValue(false);
        return null;
    }

    @Override
    public Void visit(Logical logical, Void param) {
        super.visit(logical, null);
        logical.setlValue(false);
        return null;
    }

    @Override
    public Void visit(Not not, Void param) {
        super.visit(not, null);
        not.setlValue(false);
        return null;
    }

    @Override
    public Void visit(RealLiteral realLiteral, Void param) {
        super.visit(realLiteral, null);
        realLiteral.setlValue(false);
        return null;
    }

    @Override
    public Void visit(UnaryMinus unaryMinus, Void param) {
        super.visit(unaryMinus, null);
        unaryMinus.setlValue(false);
        return null;
    }

    @Override
    public Void visit(Variable variable, Void param) {
        super.visit(variable, null);
        variable.setlValue(true);
        return null;
    }

    @Override
    public Void visit(Assignment assignment, Void param) {
        super.visit(assignment, null);
        if (!assignment.leftExpression.islValue()) {
            new ErrorType(
                    assignment.leftExpression.getLine(),
                    assignment.leftExpression.getColumn(),
                    "The expression on the left part of the assignment is not lValue"
            );
        }
        return null;
    }

    @Override
    public Void visit(Read read, Void param) {
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
}
