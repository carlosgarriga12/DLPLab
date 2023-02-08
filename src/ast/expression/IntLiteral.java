package ast.expression;

public class IntLiteral extends AbstractExpression{
    public int value;

    public IntLiteral(int line, int column, int value) {
        super(line, column);
        this.value = value;
    }
}
