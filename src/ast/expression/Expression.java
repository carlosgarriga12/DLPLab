package ast.expression;

import ast.ASTNode;
import ast.type.Type;

public interface Expression extends ASTNode {
    void setlValue(boolean lValue);
    boolean islValue();
    void setType(Type type);
    Type getType();
}
