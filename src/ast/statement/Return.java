package ast.statement;

import ast.AbstractASTNode;
import ast.expression.Expression;
import visitor.Visitor;

public class Return extends AbstractASTNode implements Statement{
    public Expression expression;

    public Return(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "return " + expression + ";";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, null);
    }
}
