package ast.expression;

import ast.type.Type;

public class Cast extends AbstractExpression{
    public Type type;
    public Expression expression;

    public Cast(int line, int column, Type type, Expression expression) {
        super(line, column);
        this.type = type;
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "(" + type.toString() + ") " + expression.toString();
    }
}
