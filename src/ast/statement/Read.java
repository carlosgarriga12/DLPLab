package ast.statement;

import ast.AbstractASTNode;
import ast.expression.Expression;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Read extends AbstractASTNode implements Statement {
    public List<Expression> expressions;

    public Read(int line, int column, List<Expression> expressions) {
        super(line, column);
        this.expressions = new ArrayList<>( expressions );
    }

    @Override
    public String toString() {
        String exps = "";
        for (Expression e: expressions) {
            exps += e.toString() + ", ";
        }
        return "input " + exps + ";";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, null);
    }
}
