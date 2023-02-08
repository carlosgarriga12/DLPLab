package ast.type;

public class RecordField {
    public Type type;
    public String name;


    public RecordField(Type type, String name) {
        this.type = type;
        this.name = name;
    }
}
