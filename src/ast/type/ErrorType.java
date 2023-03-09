package ast.type;

import errorhandler.ErrorHandler;

public class ErrorType extends AbstractType{

    public String message;

    public ErrorType(int line, int column, String message) {
        super(line, column);
        this.message = message;
        ErrorHandler.getInstance().addError(this);
    }

    @Override
    public String toString() {

        return "Error at line: " + this.line + ", column: " + this.column + ". " + this.message;
    }
}
