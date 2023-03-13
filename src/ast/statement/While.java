package ast.statement;

import ast.AbstractASTNode;
import ast.expression.Expression;
import visitor.Visitor;

import java.util.List;

public class While extends AbstractASTNode implements Statement{
    public List<Statement> statements;
    public Expression expression;

    public While(int line, int column, Expression expression, List<Statement> statements) {
        super(line, column);
        this.statements = statements;
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "While{" +
                "statements=" + statements +
                ", expression=" + expression +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, null);
    }
}
