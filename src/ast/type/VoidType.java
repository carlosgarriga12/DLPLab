package ast.type;

import visitor.Visitor;

public class VoidType extends AbstractType{
    private static VoidType instance = null;

    public static VoidType getInstance() {
        if(instance == null) {
            instance = new VoidType(0,0);
        }

        return instance;
    }

    private VoidType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "void";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, null);
    }

    @Override
    public int numberOfBytes() {
        return 0;
    }
}
