package ast.type;

import ast.definition.VariableDefinition;
import ast.expression.Variable;

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
}
