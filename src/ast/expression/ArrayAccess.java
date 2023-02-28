package ast.expression;

public class ArrayAccess extends AbstractExpression{

    public Expression leftExpression;
    public Expression rightExpression;

    public ArrayAccess(int line, int column, Expression leftExpression, Expression rightExpression) {
        super(line, column);
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public String toString() {
        return leftExpression.toString() + "[" + rightExpression.toString() + "]";
    }
}