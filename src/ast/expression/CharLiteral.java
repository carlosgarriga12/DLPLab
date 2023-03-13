package ast.expression;

import visitor.Visitor;

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

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, null);
    }
}
