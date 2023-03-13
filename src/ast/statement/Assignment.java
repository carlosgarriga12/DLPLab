package ast.statement;

import ast.AbstractASTNode;
import ast.expression.Expression;
import visitor.Visitor;

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

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, null);
    }
}
