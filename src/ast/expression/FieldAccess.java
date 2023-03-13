package ast.expression;

import visitor.Visitor;

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

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, null);
    }
}
