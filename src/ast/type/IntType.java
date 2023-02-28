package ast.type;

public class IntType extends AbstractType{

    private static IntType instance = null;

    public static IntType getInstance() {
        if(instance == null) {
            instance = new IntType(0,0);
        }

        return instance;
    }

    private IntType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "int";
    }

}
