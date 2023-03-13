package ast.type;

import visitor.Visitor;

public class RealType extends AbstractType{

    private static RealType instance = null;

    public static RealType getInstance() {
        if(instance == null) {
            instance = new RealType(0,0);
        }

        return instance;
    }

    private RealType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "real";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, null);
    }
}
