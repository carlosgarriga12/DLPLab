package ast.statement;

import ast.AbstractASTNode;
import ast.expression.Expression;

import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;
import java.util.List;

public class IfElse extends AbstractASTNode implements Statement {
    public List<Statement> ifStatements;
    public List<Statement> elseStatements;
    public Expression expression;

    public IfElse(int line, int column, Expression expression, List<Statement> ifStatements, List<Statement> elseStatements) {
        super(line, column);
        this.ifStatements = new ArrayList<>( ifStatements );
        this.elseStatements = new ArrayList<>( elseStatements );
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "IfElse{" +
                "ifStatements=" + ifStatements +
                ", elseStatements=" + elseStatements +
                ", expression=" + expression +
                '}';
    }
}
