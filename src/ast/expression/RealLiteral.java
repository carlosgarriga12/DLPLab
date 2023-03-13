package ast.expression;

import visitor.Visitor;

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

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, null);
    }
}
