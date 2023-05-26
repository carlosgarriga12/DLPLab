package codegenerator;

import ast.expression.*;
import ast.type.FunctionType;
import ast.type.IntType;
import ast.type.Type;

public class ValueCGVisitor extends AbstractCGVisitor<Object, Void>{

    private AddressCGVisitor addressCGVisitor;
    private CodeGenerator cg;

    public ValueCGVisitor(CodeGenerator cg) {
        this.cg = cg;
    }

    public void setAddressCGVisitor(AddressCGVisitor addressCGVisitor) {
        this.addressCGVisitor = addressCGVisitor;
    }

    /**
     * value[[Variable: expression -> ID]]() =
     *
     * address[[expression]]
     * <load> expression.type.suffix()
     */
    @Override
    public Void visit(Variable variable, Object param) {
        variable.accept(addressCGVisitor, param);
        cg.load(variable.getType());
        return null;
    }

    /**
     * value[[Arithmetic: expression1 -> expression2 (+|-|*|/) expression3]]() =
     *
     * value[[expression2]]
     * expression2.type.convertTo(expression1.type)
     * value[[expression3]]
     * expression3.type.convertTo(expression1.type)
     *
     * switch(exp1.op) {
     *     case "+": <add> expression1.type.suffix(); break;
     *     case "-": <sub> expression1.type.suffix(); break;
     *     case "*": <mul> expression1.type.suffix(); break;
     *     case "/": <add> expression1.type.suffix(); break;
     *     case "%": <mod> expression1.type.suffix(); break;
     * }
     *
     */
    @Override
    public Void visit(Arithmetic arithmetic, Object param) {
        arithmetic.leftExpression.accept(this, param);
        cg.promotion(arithmetic.leftExpression.getType(), arithmetic.getType());
        arithmetic.rightExpression.accept(this, param);
        cg.promotion(arithmetic.rightExpression.getType(), arithmetic.getType());

        cg.arithmetic(arithmetic);
        return null;
    }


    /**
     * value[[Cast: expression1 -> type expression2]]() =
     *
     * value[[expression2]]
     * expression2.type.convertTo(type)
     */
    @Override
    public Void visit(Cast cast, Object param) {
        cast.expression.accept(this, param);
        cg.promotion(cast.expression.getType(), cast.castType);
        return null;
    }


    /**
     * value[[CharLiteral: expression -> CHAR_LITERAL]]() =
     *
     * <pushb> expression.value
     */
    @Override
    public Void visit(CharLiteral charLiteral, Object param) {
        cg.pushb(charLiteral.value);
        return null;
    }

    /**
     * value[[IntLiteral: expression -> INT_LITERAL]]() =
     *
     * <pushi> expression.value
     */
    @Override
    public Void visit(IntLiteral intLiteral, Object param) {
        cg.pushi(intLiteral.value);
        return null;
    }

    /**
     * value[[RealLiteral: expression -> REAL_LITERAL]]() =
     *
     * <pushf> expression.value
     */
    @Override
    public Void visit(RealLiteral realLiteral, Object param) {
        cg.pushf(realLiteral.value);
        return null;
    }

    /**
     * value[[Logical: expression1 -> expression2 ('&&'| '||') expression3]]() =
     *
     * value[[expression2]]
     * value[[expression3]]
     *
     * switch(exp1.op) {
     *     case "&&": <and>; break;
     *     case "||": <or>; break;
     * }
     *
     */
    @Override
    public Void visit(Logical logical, Object param) {
        logical.leftExpression.accept(this, param);
        logical.rightExpression.accept(this, param);

        cg.logical(logical.operator);
        return null;
    }
    /**
     * value[[Not: expression1 -> expression2]]() =
     *
     * value[[expression2]]
     * <not>
     */
    @Override
    public Void visit(Not not, Object param) {
        not.expression.accept(this, param);
        cg.not();
        return null;
    }

    /**
     * value[[UnaryMinus: expression1 -> expression2]]() =
     *
     * <push> expression1.type.suffix() <0>
     * value[[expression2]]
     * <sub> expression1.type.suffix()
     */
    @Override
    public Void visit(UnaryMinus unaryMinus, Object param) {
        cg.push(unaryMinus.getType(), "0");
        unaryMinus.accept(this, param);
        cg.sub(unaryMinus.getType().suffix());
        return null;
    }

    /**
     * value[[Comparison: expression1 -> expression2 expression3]]() =
     *
     * Type highestType = cg.highestType(expression2.type, expression3.type)
     *
     * value[[expression2]]
     * expression2.type.convertTo(highestType)
     * value[[expression3]]
     * expression3.type.convertTo(highestType)
     *
     * switch(expression1.op) {
     *     case "<=": <le> highestType.suffix() break;
     *     case "<": <lt> highestType.suffix() break;
     *     case "==" <eq> highestType.suffix() break;
     *     case "!=" <ne> highestType.suffix()  break;
     *     case ">": <gt> highestType.suffix() break;
     *     case ">=": <ge> highestType.suffix() break;
     * }
     *
     */
    @Override
    public Void visit(Comparison comparison, Object param) {
        comparison.leftExpression.accept(this, param);
        Type highestType = cg.highestType(comparison.leftExpression.getType(), comparison.rightExpression.getType());
        cg.promotion(comparison.leftExpression.getType(), highestType);
        comparison.rightExpression.accept(this, param);
        cg.promotion(comparison.rightExpression.getType(), highestType);
        cg.comparison(comparison, highestType);

        cg.promotion(comparison.type, IntType.getInstance());
        return null;
    }

    /**
     * value[[ArrayAccess : expression1 -> expression2 expression3]]()
     *
     * address[[expression1]]
     * <load> expression1.type.suffix()
     */
    @Override
    public Void visit(ArrayAccess arrayAccess, Object param) {
        arrayAccess.accept(addressCGVisitor, param);
        cg.load(arrayAccess.type);
        return null;
    }

    /**
     * value[[FieldAccess: expression1 -> expression2 ID]]() =
     *
     * address[[expression1]]
     * <load> expression1.type.suffix()
     */
    @Override
    public Void visit(FieldAccess fieldAccess, Object param) {
        fieldAccess.accept(addressCGVisitor, null);
        cg.load(fieldAccess.type);
        return null;
    }

    /**
     * value[[Invocation: expression1 -> expression2 expression3*]]() =
     *
     * for(int i = 0; i < expresssion3*.size() ; i++) {
     *     value[[expression3*.get(i)]]
     *     expression3*.get(i).type.promotesTo(expression2.type.parameters.get(i).type)
     * }
     *
     * <call> expression2.name
     *
     */
    @Override
    public Void visit(FunctionInvocation functionInvocation, Object param) {

        for(int i = 0; i < functionInvocation.arguments.size() ; i++) {
            functionInvocation.arguments.get(i).accept(this, param);
            cg.promotion(
                    functionInvocation.arguments.get(i).getType(),
                    ((FunctionType)functionInvocation.variable.type).parameters.get(i).getType());
        }

        cg.call(functionInvocation.variable.name);
        return null;
    }
}
