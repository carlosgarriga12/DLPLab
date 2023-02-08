package ast.type;

import ast.definition.VariableDefinition;

import java.util.ArrayList;
import java.util.List;

public class FunctionType extends AbstractType{
    public List<VariableDefinition> parameters = new ArrayList<>();

}
