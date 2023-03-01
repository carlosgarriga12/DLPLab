package ast.expression;

public class Comparison extends AbstractExpression{

    public Expression leftExpression;
    public Expression rightExpression;
    public String operator;

    public Comparison(int line, int column, Expression leftExpression, Expression rightExpression, String operator) {
        super(line, column);
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.operator = operator;
    }
}
