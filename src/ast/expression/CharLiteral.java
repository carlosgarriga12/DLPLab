package ast.expression;

public class CharLiteral extends AbstractExpression{
    public char value;


    public CharLiteral(int line, int column, char value) {
        super(line, column);
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
