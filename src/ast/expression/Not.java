package ast.expression;

import visitor.Visitor;

public class Not extends AbstractExpression{
    public Expression expression;


    public Not(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "!" + expression.toString();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, null);
    }
}
