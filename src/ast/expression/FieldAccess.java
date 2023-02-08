package ast.expression;

public class FieldAccess extends AbstractExpression{
    public String fieldName;
    public Expression expression;

    public FieldAccess(int line, int column, String fieldName, Expression expression) {
        super(line, column);
        this.expression = expression;
        this.fieldName = fieldName;
    }
}
