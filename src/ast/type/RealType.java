package ast.type;

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

}
