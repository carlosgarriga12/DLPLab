package ast.type;

import ast.ASTNode;
import errorhandler.ErrorHandler;
import visitor.Visitor;

public class ErrorType extends AbstractType{

    public String message;

    public ErrorType(int line, int column, String message) {
        super(line, column);
        this.message = message;
        ErrorHandler.getInstance().addError(this);
    }

    @Override
    public String toString() {
        return "Error at line: " + this.line + ", column: " + this.column + ". " + this.message;
    }

    @Override
    public Type assignment(Type type, ASTNode node) {
        return this;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, null);
    }

    @Override
    public Type squareBrackets(Type type, ASTNode node) {
        return this;
    }

    @Override
    public Type cast(Type type, ASTNode node){
        return this;
    }

    @Override
    public Type comparison(Type type, ASTNode node) {
        return this;
    }

    @Override
    public Type dot(String id, ASTNode node) {
        return this;
    }

    @Override
    public Type logical(Type type, ASTNode node) {
        return this;
    }

    @Override
    public Type not(ASTNode node) {
        return this;
    }

    @Override
    public Type unaryMinus(ASTNode node) {
        return this;
    }

    @Override
    public boolean mustBeSubtype(Type type, ASTNode node) {
        return false;
    }

}
