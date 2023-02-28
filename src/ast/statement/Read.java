package ast.statement;

import ast.AbstractASTNode;
import ast.expression.Expression;

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
        return "Read{" +
                "expressions=" + expressions +
                '}';
    }
}
