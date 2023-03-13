package ast.type;

import visitor.Visitor;

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

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, null);
    }
}
