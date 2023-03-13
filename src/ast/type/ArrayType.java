package ast.type;

import visitor.Visitor;

public class ArrayType extends AbstractType{
    public int size;
    public Type type;

    public ArrayType(int line, int column, Type type, int size) {
        super(line, column);
        this.type = type;
        this.size = size;
    }

    @Override
    public String toString() {
        return "ArrayType{" +
                "size=" + size +
                ", type=" + type +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, null);
    }
}
