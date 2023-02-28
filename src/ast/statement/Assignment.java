package ast.statement;

import ast.AbstractASTNode;
import ast.expression.Expression;

public class Assignment extends AbstractASTNode implements Statement{
    public Expression leftExpression;
    public Expression rightExpression;

    public Assignment(int line, int column, Expression leftExpression, Expression rightExpression) {
        super(line, column);
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "leftExpression=" + leftExpression +
                ", rightExpression=" + rightExpression +
                '}';
    }
}
