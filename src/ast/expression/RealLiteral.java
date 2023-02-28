package ast.expression;

public class RealLiteral extends AbstractExpression{
    public double value;


    public RealLiteral(int line, int column, double value) {
        super(line, column);
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
