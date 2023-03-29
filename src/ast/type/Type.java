package ast.type;

import ast.ASTNode;

import java.util.List;

public interface Type extends ASTNode {
    Type arithmetic(Type type, ASTNode node);
    Type squareBrackets(Type type, ASTNode node);
    Type cast(Type type, ASTNode node);
    Type comparison(Type type, ASTNode node);
    Type dot(String id, ASTNode node);
    Type parenthesis(List<Type> arguments, ASTNode node);
    Type logical(Type type, ASTNode node);
    Type not(ASTNode node);
    Type unaryMinus(ASTNode node);

    Type assignment(Type type, ASTNode node);
    void asLogical(Type type, ASTNode node);
    boolean mustBeSubtype(Type type, ASTNode node);

}
