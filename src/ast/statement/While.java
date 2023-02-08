package ast.statement;

import ast.AbstractASTNode;
import ast.expression.Expression;

import java.util.List;

public class While extends AbstractASTNode implements Statement{
    public List<Statement> statements;
    public Expression expression;

    public While(int line, int column, List<Statement> statements, Expression expression) {
        super(line, column);
        this.statements = statements;
        this.expression = expression;
    }
}
