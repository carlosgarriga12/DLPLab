package ast.expression;

import visitor.Visitor;

public class Variable extends AbstractExpression{
    public String name;

    public Variable(int line, int column, String name) {
        super(line, column);
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, null);
    }
}
