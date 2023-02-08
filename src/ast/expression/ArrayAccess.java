package ast.expression;

public class ArrayAccess extends AbstractExpression{

    public String name;
    public Expression leftExpression;
    public Expression rightExpression;

    public ArrayAccess(int line, int column, String name, Expression leftExpression, Expression rightExpression) {
        super(line, column);
        this.name = name;
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }
}
