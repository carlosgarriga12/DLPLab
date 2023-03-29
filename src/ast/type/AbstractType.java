package ast.type;

import ast.ASTNode;
import ast.AbstractASTNode;

import java.util.List;

public abstract class AbstractType extends AbstractASTNode implements Type {
    public AbstractType(int line, int column) {
        super(line, column);
    }

    @Override
    public Type assignment(Type type, ASTNode node) {
        return new ErrorType(
                node.getLine(),
                node.getColumn(),
                String.format("Assignment operation not supported between %s and %s", this, type)
        );
    }

    @Override
    public Type arithmetic(Type type, ASTNode node) {
        return new ErrorType(
                node.getLine(),
                node.getColumn(),
                String.format(
                        "Arithmetic operation not supported between %s and %s", this, type)
        );
    }

    @Override
    public Type squareBrackets(Type type, ASTNode node) {
        return new ErrorType(
                node.getLine(),
                node.getColumn(),
                String.format(
                        "Indexing operation not supported between %s and %s", this, type)
        );
    }

    @Override
    public Type cast(Type type, ASTNode node) {
        return new ErrorType(
                node.getLine(),
                node.getColumn(),
                String.format(
                        "Cast operation not supported between %s and %s", this, type)
        );
    }

    @Override
    public Type comparison(Type type, ASTNode node) {
        return new ErrorType(
                node.getLine(),
                node.getColumn(),
                String.format(
                        "Comparison operation not supported between %s and %s", this, type)
        );
    }

    @Override
    public Type dot(String id, ASTNode node) {
        return new ErrorType(
                node.getLine(),
                node.getColumn(),
                String.format(
                        "Dot operation not supported for type %s", this)
        );
    }

    @Override
    public Type parenthesis(List<Type> arguments, ASTNode node) {
        return new ErrorType(
                node.getLine(),
                node.getColumn(),
                String.format(
                        "Parenthesis operation not supported for type %s", this)
        );
    }

    @Override
    public Type logical(Type type, ASTNode node) {
        return new ErrorType(
                node.getLine(),
                node.getColumn(),
                String.format(
                        "Logical operation not supported between type %s and %s", this, type)
        );
    }

    @Override
    public Type not(ASTNode node) {
        return new ErrorType(
                node.getLine(),
                node.getColumn(),
                String.format(
                        "Not operation not supported for type %s", this)
        );
    }

    @Override
    public Type unaryMinus(ASTNode node) {
        return new ErrorType(
                node.getLine(),
                node.getColumn(),
                String.format(
                        "Unary minus operation not supported for type %s", this)
        );
    }

    @Override
    public void asLogical(Type type, ASTNode node) {
        new ErrorType(
                node.getLine(),
                node.getColumn(),
                String.format("Expression of type %s not valid for logical expressions", type));
    }

    @Override
    public boolean mustBeSubtype(Type type, ASTNode node) {
        return false;
    }

}
