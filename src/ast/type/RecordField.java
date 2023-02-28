package ast.type;

public class RecordField {
    public Type type;
    public String name;
    public int line;
    public int column;

    public RecordField(int line, int column, Type type, String name) {
        this.line = line;
        this.column = column;
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
}
