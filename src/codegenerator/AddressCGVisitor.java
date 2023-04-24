package codegenerator;

import ast.definition.VariableDefinition;
import ast.expression.ArrayAccess;
import ast.expression.FieldAccess;
import ast.expression.Variable;
import ast.type.IntType;
import ast.type.RecordType;

public class AddressCGVisitor extends AbstractCGVisitor<Object, Void> {

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
    public Void visit(Variable variable, Object param) {
        if(variable.definition.getScope() == 0) {
            cg.pushAddress(((VariableDefinition)variable.definition).getOffset());
        } else {
            cg.pushBP();
            cg.pushi(((VariableDefinition)variable.definition).getOffset());
            cg.add(IntType.getInstance().suffix());
        }
        return null;
    }

    /**
     * address[[ArrayAccess: expression1 -> expression2 expression3]]() =
     *
     * address[[expression2]]()
     *
     * value[[expression3]]()
     * <pushi> expression1.type.numberOfBytes()
     * <muli>
     * <addi>
     *
     */
    @Override
    public Void visit(ArrayAccess arrayAccess, Object param) {
        arrayAccess.leftExpression.accept(this, param);
        arrayAccess.rightExpression.accept(valueCGVisitor, param);

        cg.pushi(arrayAccess.type.numberOfBytes());
        cg.mul('i');
        cg.add('i');
        return null;
    }

    /**
     * address[[FieldAccess: expression1 -> expression2 ID]]() =
     *
     * address[[expression2]]
     * <pushi> expression2.type.getField(ID).offset
     *
     * <addi>
     */
    @Override
    public Void visit(FieldAccess fieldAccess, Object param) {
        fieldAccess.expression.accept(this, param);
        cg.pushi(((RecordType) fieldAccess.expression.getType()).findRecordFieldByName(fieldAccess.fieldName).offset);
        cg.add('i');
        return null;
    }


}
