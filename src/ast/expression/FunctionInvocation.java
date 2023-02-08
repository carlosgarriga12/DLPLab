package ast.expression;

import ast.statement.Statement;

import java.util.ArrayList;
import java.util.List;

public class FunctionInvocation extends AbstractExpression implements Statement{
    public List<Expression> arguments;
    public Variable variable;

    public FunctionInvocation(int line, int column, Variable variable, List<Expression> arguments) {
        super(line, column);
        this.variable = variable;
        this.arguments = new ArrayList<>( arguments );

    }
}
