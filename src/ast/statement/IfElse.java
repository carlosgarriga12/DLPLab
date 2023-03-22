package ast.statement;

import ast.AbstractASTNode;
import ast.expression.Expression;
import visitor.Visitor;

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
        String ifStmts = "";
        for(Statement st: ifStatements) {
            ifStmts += st.toString() + "\n";
        }
        if (elseStatements.isEmpty()) {
            return "if (" + expression.toString() + ")" + "{" + ifStmts + "}";
        } else {
            String elseStmts = "";
            for(Statement st: elseStatements) {
                elseStmts += st.toString() + "\n";
            }
            return "if (" + expression.toString() + ")" + "{" + ifStmts + "}" + "else { " + elseStmts + "}";
        }
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, null);
    }
}
