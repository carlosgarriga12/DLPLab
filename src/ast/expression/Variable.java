package ast.expression;

public class Variable extends AbstractExpression{
    public String name;

    public Variable(int line, int column, String name) {
        super(line, column);
        this.name = name;
    }
}
