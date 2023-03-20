package ast.definition;

import ast.AbstractASTNode;
import ast.type.Type;

public abstract class AbstractDefinition extends AbstractASTNode implements Definition {
    protected Type type;
    protected String name;
    protected int scope;

    @Override
    public Type getType() {
        return this.type;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public AbstractDefinition(int line, int column, Type type, String name) {
        super(line, column);
        this.type = type;
        this.name = name;

    }

    @Override
    public int getScope() {
        return this.scope;
    }

    @Override
    public void setScope(int scope) {
        this.scope = scope;
    }

}
