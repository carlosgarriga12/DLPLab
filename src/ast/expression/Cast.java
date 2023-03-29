package ast.expression;

import ast.type.Type;
import visitor.Visitor;

public class Cast extends AbstractExpression{
    public Type castType;
    public Expression expression;

    public Cast(int line, int column, Type type, Expression expression) {
        super(line, column);
        this.castType = type;
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "(" + castType.toString() + ") " + expression.toString();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, null);
    }
}
