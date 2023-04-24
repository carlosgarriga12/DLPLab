package ast.type;

import ast.ASTNode;
import visitor.Visitor;

public class RealType extends AbstractType{

    private static RealType instance = null;

    public static RealType getInstance() {
        if(instance == null) {
            instance = new RealType(0,0);
        }

        return instance;
    }

    private RealType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "real";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, null);
    }

    @Override
    public Type assignment(Type type, ASTNode node) {
        if(type instanceof CharType || type instanceof IntType || type instanceof RealType) {
            return this;
        }
        if(type instanceof ErrorType) {
            return type;
        }

        return new ErrorType(
                node.getLine(),
                node.getColumn(),
                String.format("Cannot assign a %s into a Real", type)
        );
    }

    @Override
    public Type arithmetic(Type type, ASTNode node) {
        if(type instanceof RealType) {
            return this;
        }
        if(type instanceof IntType) {
            return this;
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
        if(type instanceof CharType) {
            return CharType.getInstance();
        }
        return new ErrorType(
                node.getLine(),
                node.getColumn(),
                String.format("Cannot cast from type %s to %s type", this, type)
        );
    }

    @Override
    public boolean mustBeSubtype(Type type, ASTNode node) {
        return type instanceof RealType;
    }

    @Override
    public Type unaryMinus(ASTNode node) {
        return this;
    }

    @Override
    public int numberOfBytes() {
        return 4;
    }

    @Override
    public char suffix() {
        return 'f';
    }

}
