package ast.expression;

public class UnaryMinus extends AbstractExpression{
    public Expression expression;


    public UnaryMinus(int line, int column) {
        super(line, column);
        this.expression = expression;
    }
}
