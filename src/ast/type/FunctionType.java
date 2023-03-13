package ast.type;

import ast.definition.VariableDefinition;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class FunctionType extends AbstractType{
    public List<VariableDefinition> parameters;
    public Type returnType;

    public FunctionType(int line, int column, List<VariableDefinition> parameters, Type returnType) {
        super(line, column);
        this.parameters = new ArrayList<>( parameters );
        this.returnType = returnType;
    }

    @Override
    public String toString() {
        return "FunctionType{" +
                "parameters=" + parameters +
                ", returnType=" + returnType +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, null);
    }
}
