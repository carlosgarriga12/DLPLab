package ast.type;

import ast.AbstractASTNode;
import visitor.Visitor;

public class RecordField extends AbstractASTNode {
    public Type type;
    public String name;

    public RecordField(int line, int column, Type type, String name) {
        super(line, column);
        this.type = type;
        this.name = name;
    }

    @Override
    public String toString() {
        return "RecordField{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", line=" + line +
                ", column=" + column +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, null);
    }
}
