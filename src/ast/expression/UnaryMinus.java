package ast.expression;

public class UnaryMinus extends AbstractExpression{
    public Expression expression;

    public UnaryMinus(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "- " + expression.toString();
    }
}
