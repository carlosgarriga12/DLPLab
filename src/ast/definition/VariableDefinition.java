package ast.definition;

import ast.statement.Statement;
import ast.type.Type;

public class VariableDefinition extends AbstractDefinition implements Statement {

    public VariableDefinition(int line, int column, Type type, String name)
    {
        super(line, column, type, name);
    }
}
