package ast.type;

public class ArrayType extends AbstractType{
    public int size;
    public String name;
    public Type type;

    public ArrayType(int line, int column, String name, Type type, int size) {
        super(line, column);
        this.name = name;
        this.type = type;
        this.size = size;
    }
}
