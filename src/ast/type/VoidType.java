package ast.type;

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

}
