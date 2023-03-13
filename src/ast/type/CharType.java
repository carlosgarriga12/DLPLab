package ast.type;

import visitor.Visitor;

public class CharType extends AbstractType{

    private static CharType instance = null;

    public static CharType getInstance() {
        if(instance == null) {
            instance = new CharType(0,0);
        }

        return instance;
    }

    private CharType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "char";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, null);
    }
}
