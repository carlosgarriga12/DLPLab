package ast.type;

import ast.ASTNode;
import visitor.Visitor;

public class CharType extends AbstractType{

    private static CharType instance = null;

    public static CharType getInstance() {
        if(instance == null) {
            instance = new CharType(0,0);
        }

        return instance;
    }

    private CharType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "char";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, null);
    }

    @Override
    public Type assignment(Type type, ASTNode node) {
        if(type instanceof CharType) {
            return this;
        }

        if(type instanceof ErrorType) {
            return type;
        }

        return new ErrorType(
                node.getLine(),
                node.getColumn(),
                String.format("Cannot assign a %s into a char", type));
    }

    @Override
    public Type arithmetic(Type type, ASTNode node) {
        if(type instanceof RealType) {
            return RealType.getInstance();
        }
        if(type instanceof IntType) {
            return IntType.getInstance();
        }
        if(type instanceof CharType) {
            return this;
        }
        if(type instanceof ErrorType) {
            return type;
        }

        return new ErrorType(
                node.getLine(),
                node.getColumn(),
                String.format("Cannot perform arithmetic operation between CharType and %s", type)
        );
    }

    @Override
    public Type cast(Type type, ASTNode node) {
        if(type instanceof IntType) {
            return IntType.getInstance();
        }
        if(type instanceof RealType) {
            return RealType.getInstance();
        }
        return new ErrorType(
                node.getLine(),
                node.getColumn(),
                String.format("Cannot cast from type %s to %s type", this, type)
        );
    }

    @Override
    public boolean mustBeSubtype(Type type, ASTNode node) {
        return true;
    }

    @Override
    public int numberOfBytes() {
        return 1;
    }


}
