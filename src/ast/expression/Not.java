package ast.expression;

public class Not extends AbstractExpression{
    public Expression expression;


    public Not(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }
}
