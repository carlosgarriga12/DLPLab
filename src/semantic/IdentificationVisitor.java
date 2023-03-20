package semantic;

import ast.definition.Definition;
import ast.definition.FunctionDefinition;
import ast.definition.VariableDefinition;
import ast.expression.Variable;
import ast.statement.IfElse;
import ast.statement.While;
import ast.type.ErrorType;
import symboltable.SymbolTable;
import visitor.AbstractVisitor;

public class IdentificationVisitor extends AbstractVisitor<Void, Void> {
    public SymbolTable st = new SymbolTable();

    @Override
    public Void visit(VariableDefinition variableDefinition, Void param) {
        super.visit(variableDefinition, param);
        st.insert(variableDefinition);
        return null;
    }

    @Override
    public Void visit(FunctionDefinition functionDefinition, Void param) {
        st.insert(functionDefinition);
        st.set();
        super.visit(functionDefinition, param);
        st.reset();
        return null;
    }

    @Override
    public Void visit(Variable variable, Void param) {
        super.visit(variable, null);
        Definition definition = st.find(variable.name);
        if (definition == null) {
            variable.definition = new VariableDefinition(
                    variable.getLine(),
                    variable.getColumn(),
                    new ErrorType(
                            variable.getLine(),
                            variable.getColumn(),
                            "Definition of variable " + variable.name + " has not been defined"
                    ),
                    variable.name);

        } else {
            variable.definition = definition;
        }
        return null;
    }
}