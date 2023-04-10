package ast.type;

import ast.ASTNode;
import visitor.Visitor;

public class ArrayType extends AbstractType{
    public int size;
    public Type type;

    public ArrayType(int line, int column, Type type, int size) {
        super(line, column);
        this.type = type;
        this.size = size;
    }

    @Override
    public String toString() {
        return "ArrayType{" +
                "size=" + size +
                ", type=" + type +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, null);
    }

    @Override
    public boolean mustBeSubtype(Type type, ASTNode node) {
        return false;
    }

    @Override
    public Type squareBrackets(Type type, ASTNode node) {
        if(type instanceof IntType) {
            return this.type;
        }

        if(type instanceof ErrorType) {
            return type;
        }

        return new ErrorType(
                node.getLine(),
                node.getColumn(),
                String.format("Cannot perform indexing operation " +
                        "since indexing type is %s and not IntType", type)
        );
    }

    @Override
    public Type assignment(Type type, ASTNode node) {
        if(type instanceof ArrayType) {
            return this;
        }

        if(type instanceof ErrorType) {
            return type;
        }
        return new ErrorType(
                node.getLine(),
                node.getColumn(),
                String.format("Cannot assign a %s into an array", type));

    }

    @Override
    public int numberOfBytes() {
        return this.type.numberOfBytes() * size;
    }
}
