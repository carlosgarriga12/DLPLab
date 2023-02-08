package ast.expression;

public class Arithmetic extends AbstractExpression{
    public Expression leftExpression;
    public Expression rightExpression;
    public String operator;

    public Arithmetic(int line, int column, Expression leftExpression, Expression rightExpression, String operator) {
        super(line, column);
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.operator = operator;
    }
}
