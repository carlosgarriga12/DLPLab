package ast.type;

import ast.ASTNode;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class RecordType extends AbstractType{
    public List<RecordField> recordFields;

    public RecordType(int line, int column, List<RecordField> recordFields) {
        super(line, column);
        this.recordFields = new ArrayList<>( recordFields );
    }

    private RecordField findRecordFieldByName(String id) {
        RecordField rf = null;

        for(RecordField recordField: recordFields) {
            if(recordField.name.equals(id)) {
                rf = recordField;
            }
        }
        return rf;
    }

    @Override
    public String toString() {
        return "struct";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, null);
    }

    @Override
    public Type assignment(Type type, ASTNode node) {
        if(type instanceof RecordType) {
            return this;
        }

        if(type instanceof ErrorType) {
            return type;
        }

        return new ErrorType(
                node.getLine(),
                node.getColumn(),
                String.format("Cannot assign a %s into a record", type));
    }

    @Override
    public Type dot(String id, ASTNode node) {
        RecordField rf = findRecordFieldByName(id);

        if(rf == null) {
            return new ErrorType(
                    node.getLine(),
                    node.getColumn(),
                    String.format("Field not defined in struct"));
        } else {
            return rf.type;
        }
    }
}
