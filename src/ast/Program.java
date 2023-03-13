package ast;

import ast.definition.Definition;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Program extends AbstractASTNode {
    public List<Definition> definitions;

    public Program(int line, int column, List<Definition> definitions) {
        super(line, column);
        this.definitions = new ArrayList<>( definitions );
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, null);
    }
}
