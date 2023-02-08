package ast.type;

import java.util.ArrayList;
import java.util.List;

public class RecordType extends AbstractType{
    public String name;
    public List<RecordField> recordFields = new ArrayList<>();

}
