package ast.type;

import ast.AbstractASTNode;
import visitor.Visitor;

public class RecordField extends AbstractASTNode {
    public Type type;
    public String name;

    public int offset;

    public RecordField(int line, int column, Type type, String name) {
        super(line, column);
        this.type = type;
        this.name = name;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        return name + ": " + type.toString() + ";";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, null);
    }
}
