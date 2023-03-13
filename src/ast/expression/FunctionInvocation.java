package ast.expression;

import ast.statement.Statement;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class FunctionInvocation extends AbstractExpression implements Statement {
    public List<Expression> arguments;
    public Variable variable;

    public FunctionInvocation(int line, int column, Variable variable, List<Expression> arguments) {
        super(line, column);
        this.variable = variable;
        this.arguments = new ArrayList<>( arguments );
    }

    @Override
    public String toString() {
        String aux="";

        for(Expression expression : arguments) {
            aux+= expression.toString() + ",";
        }
        return variable.toString() + "(" + aux + ")";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, null);
    }
}
