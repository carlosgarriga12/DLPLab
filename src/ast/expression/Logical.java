package ast.expression;

import visitor.Visitor;

public class Logical extends AbstractExpression{
    public Expression leftExpression;
    public Expression rightExpression;
    public String operator;

    public Logical(int line, int column, Expression leftExpression, Expression rightExpression, String operator) {
        super(line, column);
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.operator = operator;
    }

    @Override
    public String toString() {
        return leftExpression.toString() + " " + operator + " " + rightExpression.toString();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, null);
    }
}
