package ast.type;

import ast.ASTNode;
import visitor.Visitor;

public class IntType extends AbstractType{

    private static IntType instance = null;

    public static IntType getInstance() {
        if(instance == null) {
            instance = new IntType(0,0);
        }

        return instance;
    }

    private IntType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "int";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, null);
    }

    @Override
    public Type assignment(Type type, ASTNode node) {
        if(type instanceof IntType || type instanceof CharType) {
            return this;
        }
        if(type instanceof ErrorType) {
            return type;
        }

        return new ErrorType(
                node.getLine(),
                node.getColumn(),
                String.format("Cannot assign a %s into an Int", type)
        );
    }

    @Override
    public void asLogical(Type type, ASTNode node) {
        /*Only valid case*/
    }

    @Override
    public Type arithmetic(Type type, ASTNode node) {
        if(type instanceof RealType) {
            return RealType.getInstance();
        }
        if(type instanceof CharType) {
            return this;
        }
        if(type instanceof IntType) {
            return this;
        }
        if(type instanceof ErrorType) {
            return type;
        }
        return new ErrorType(
                node.getLine(),
                node.getColumn(),
                String.format("Cannot perform arithmetic operation between IntType and %s", type)
        );
    }

    @Override
    public Type cast(Type type, ASTNode node) {
        if(type instanceof RealType) {
            return RealType.getInstance();
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
        if(type instanceof IntType || type instanceof RealType) {
            return true;
        }
        return false;
    }

    @Override
    public Type unaryMinus(ASTNode node) {
        return this;
    }

    @Override
    public int numberOfBytes() {
        return 2;
    }

    @Override
    public char suffix() {
        return 'i';
    }

    @Override
    public Type comparison(Type type, ASTNode astNode) {
        if (type.equals(this)) {
            return this;
        }
        return new ErrorType(
                astNode.getLine(),
                astNode.getColumn(),
                String.format("Cannot perform comparison between type %s and %s type", this, type)
        );
    }

    @Override
    public Type logical(Type type, ASTNode astNode) {
        if (type.equals(this)) {
            return this;
        }
        return new ErrorType(
                astNode.getLine(),
                astNode.getColumn(),
                String.format("Cannot perform logical between type %s and %s type", this, type)
        );
    }

    @Override
    public Type not(ASTNode astNode) {
        return this;
    }
}
