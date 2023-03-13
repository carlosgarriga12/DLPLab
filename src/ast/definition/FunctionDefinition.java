package ast.definition;

import ast.statement.Statement;
import ast.type.Type;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class FunctionDefinition extends AbstractDefinition {

    public List<Statement> statements;

    public FunctionDefinition(int line, int column, Type type, String name, List<Statement> statements) {
        super(line, column, type, name);
        this.statements = new ArrayList<>( statements );
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, null);
    }
}
