package ast.statement;

import ast.AbstractASTNode;
import ast.expression.Expression;
import visitor.Visitor;

import javax.swing.plaf.nimbus.State;
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
        String stmts = "";
        for(Statement st: statements) {
            stmts+= st.toString() + "\n";
        }
        return "while ( " + expression + " ) {\n" + stmts;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, null);
    }
}
