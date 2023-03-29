package ast.expression;

import ast.AbstractASTNode;
import ast.type.Type;

public abstract class AbstractExpression extends AbstractASTNode implements Expression{

    public boolean lValue;
    public Type type;

    public AbstractExpression(int line, int column) {
        super(line, column);
    }

    public void setlValue(boolean lValue) {
        this.lValue = lValue;
    }

    public boolean islValue() {
        return this.lValue;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return this.type;
    }
}
