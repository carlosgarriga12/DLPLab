package ast.expression;

public class FieldAccess extends AbstractExpression{
    public String fieldName;
    public Expression expression;

    public FieldAccess(int line, int column, Expression expression, String fieldName) {
        super(line, column);
        this.expression = expression;
        this.fieldName = fieldName;
    }

    @Override
    public String toString() {
        return expression.toString() + "." + fieldName;
    }
}
