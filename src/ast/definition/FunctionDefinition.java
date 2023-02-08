package ast.definition;

import ast.type.Type;

public class FunctionDefinition extends AbstractDefinition {

    public FunctionDefinition(int line, int column, Type type, String name) {
        super(line, column, type, name);
    }
}
