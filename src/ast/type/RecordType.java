package ast.type;

import java.util.ArrayList;
import java.util.List;

public class RecordType extends AbstractType{
    public String name;
    public List<RecordField> recordFields;

    public RecordType(int line, int column, String name, List<RecordField> recordFields) {
        super(line, column);
        this.name = name;
        this.recordFields = new ArrayList<>( recordFields );
    }
}
