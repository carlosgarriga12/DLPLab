package ast.definition;

import ast.ASTNode;
import ast.type.Type;

public interface Definition extends ASTNode {
    Type getType();
    String getName();
    int getScope();
    void setScope(int scope);
}

