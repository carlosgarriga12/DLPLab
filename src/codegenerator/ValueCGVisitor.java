package codegenerator;

import ast.expression.*;

public class ValueCGVisitor extends AbstractCGVisitor<Void, Void>{

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
    public Void visit(Variable variable, Void param) {
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
     * }
     *
     */
    @Override
    public Void visit(Arithmetic arithmetic, Void param) {
        arithmetic.leftExpression.accept(this, param);
        cg.promotion(arithmetic.leftExpression.getType(), arithmetic.getType());
        arithmetic.rightExpression.accept(this, param);
        cg.promotion(arithmetic.leftExpression.getType(), arithmetic.getType());

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
    public Void visit(Cast cast, Void param) {
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
    public Void visit(CharLiteral charLiteral, Void param) {
        cg.pushb(charLiteral.value);
        return null;
    }

    /**
     * value[[IntLiteral: expression -> INT_LITERAL]]() =
     *
     * <pushi> expression.value
     */
    @Override
    public Void visit(IntLiteral intLiteral, Void param) {
        cg.pushi(intLiteral.value);
        return null;
    }

    /**
     * value[[RealLiteral: expression -> REAL_LITERAL]]() =
     *
     * <pushf> expression.value
     */
    @Override
    public Void visit(RealLiteral realLiteral, Void param) {
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
    public Void visit(Logical logical, Void param) {
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
    public Void visit(Not not, Void param) {
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
    public Void visit(UnaryMinus unaryMinus, Void param) {
        cg.push(unaryMinus.getType(), "0");
        unaryMinus.accept(this, param);
        cg.sub(unaryMinus.getType().suffix());
        return null;
    }
}
