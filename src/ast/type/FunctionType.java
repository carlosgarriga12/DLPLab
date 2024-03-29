package ast.type;

import ast.ASTNode;
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

    @Override
    public Type parenthesis(List<Type> types, ASTNode node) {
        if(parameters.size() != types.size()) {
            return new ErrorType(
                    node.getLine(),
                    node.getColumn(),
                    String.format(
                            "The function needs to receive %d arguments and it is receiving %d",
                            parameters.size(),
                            types.size()
                    )
            );
        }

        for(int i = 0; i < types.size(); i++) {
            VariableDefinition vd = parameters.get(i);
            if(!types.get(i).isSubtypeOf(vd.getType(), node)) {
                return new ErrorType(
                        node.getLine(),
                        node.getColumn(),
                        String.format("Argument of type %s is not promotable to type %s", types.get(i), vd.getType()));
            }
        }

        if(returnType == null) {
            return VoidType.getInstance();
        } else {
            return returnType;
        }
    }

    //In the case of delegates, a function is just a location in memory so
    //in this case we set 2 as the number of bytes
    @Override
    public int numberOfBytes() {
        return 2;
    }
}
