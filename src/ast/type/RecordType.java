package ast.type;

import java.util.ArrayList;
import java.util.List;

public class RecordType extends AbstractType{
    public List<RecordField> recordFields;

    public RecordType(int line, int column, List<RecordField> recordFields) {
        super(line, column);
        this.recordFields = new ArrayList<>( recordFields );
    }

    @Override
    public String toString() {
        return "RecordType{" +
                "recordFields=" + recordFields +
                '}';
    }
}
