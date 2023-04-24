package ast.definition;

import ast.statement.Statement;
import ast.type.Type;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class FunctionDefinition extends AbstractDefinition {

    public List<Statement> statements;
    public List<VariableDefinition> parameters;

    public FunctionDefinition(int line, int column, Type type, String name, List<Statement> statements) {
        super(line, column, type, name);
        this.statements = new ArrayList<>( statements );
        this.parameters = new ArrayList<>();
    }

    public void addParameters(List<VariableDefinition> variableDefinitions) {
        variableDefinitions.stream().forEach(vd -> parameters.add(vd));
    }

    @Override
    public String toString() {
        return "def " + getName();
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, null);
    }
}
