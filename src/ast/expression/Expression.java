package ast.expression;

import ast.ASTNode;

public interface Expression extends ASTNode {
    void setlValue(boolean lValue);
    boolean islValue();
}
