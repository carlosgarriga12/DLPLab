package codegenerator;

import ast.definition.VariableDefinition;
import ast.expression.Variable;
import ast.type.IntType;

public class AddressCGVisitor extends AbstractCGVisitor<Void, Void> {

    private ValueCGVisitor valueCGVisitor;
    private CodeGenerator cg;

    public AddressCGVisitor(CodeGenerator cg) {
        this.cg = cg;
    }

    public void setValueCGVisitor(ValueCGVisitor valueCGVisitor) {
        this.valueCGVisitor = valueCGVisitor;
    }

    /**
     * address[[Variable: expression -> ID]]() =
     *
     * if(expression.definition.scope == 0)
     *      <pusha> + expression.definition.offset
     *  else
     *      <push bp>
     *      <pushi> expression.definition.offset
     *      <addi>
     */
    @Override
    public Void visit(Variable variable, Void param) {
        if(variable.definition.getScope() == 0) {
            cg.pushAddress(((VariableDefinition)variable.definition).getOffset());
        } else {
            cg.pushBP();
            cg.pushi(((VariableDefinition)variable.definition).getOffset());
            cg.add(IntType.getInstance().suffix());
        }
        return null;
    }
}
