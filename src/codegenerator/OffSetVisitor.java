package codegenerator;

import ast.definition.VariableDefinition;
import ast.type.FunctionType;
import ast.type.RecordField;
import ast.type.RecordType;
import visitor.AbstractVisitor;

public class OffSetVisitor extends AbstractVisitor<Void, Void> {
    //For global variables
    public int totalNumberOfBytesSum = 0;

    //For local variables
    public int totalNumberBytesSumLocal = 0;

    @Override
    public Void visit(RecordType recordType, Void param) {
        int numberOfBytes = 0;

        for(RecordField rf: recordType.recordFields) {
            rf.setOffset(numberOfBytes);
            numberOfBytes += rf.type.numberOfBytes();
            rf.accept(this, null);
        }

        return null;
    }

    /*
    * In the case of the variable definitions we have two posibilities:
    * -Global variables
    * -Local variables
    *
    * For the global variables we check that the scope is zero.
    *
    * In the other case we have a problem is that we cannot distinguish
    * if a local variable can be a parameter
    * of the function or a local variable of the function.
    *
    * The solution to this is: when the scope is not 0 we assume
    * that it is a local variable and we compute the offsets. For the parameters
    * we are going to traverse them through the functionType node.
    *
    * BE CAREFUL. We do not have to traverse the children because we would enter
    * this implementation but we are not interested in.
    *
    * */
    @Override
    public Void visit(VariableDefinition varDef, Void param) {

        if(varDef.getScope() == 0) { //Global variable
            varDef.setOffset(totalNumberOfBytesSum);
            totalNumberOfBytesSum += varDef.getType().numberOfBytes();
        } else {  //Local variables
            totalNumberBytesSumLocal += varDef.getType().numberOfBytes();
            varDef.setOffset(-1 * totalNumberBytesSumLocal);
        }
        super.visit(varDef, null);
        return null;
    }

    @Override
    public Void visit(FunctionType functionType, Void param) {
        int offsetParameters = 4;
        totalNumberBytesSumLocal = 0;

        for(int i = functionType.parameters.size() - 1; i >= 0 ; i--) {
            functionType.parameters.get(i).setOffset(offsetParameters);
            offsetParameters += functionType.parameters.get(i).getType().numberOfBytes();
        }
        return null;
    }
}
