package ast.program;

import ast.AbstractASTNode;
import ast.definition.Definition;

import java.util.ArrayList;
import java.util.List;

public class Program extends AbstractASTNode {
    List<Definition> definitions;

    public Program(int line, int column, List<Definition> definitions) {
        super(line, column);
        this.definitions = new ArrayList<>( definitions );
    }
}
