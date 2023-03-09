package errorhandler;

import ast.type.ErrorType;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ErrorHandler {

    public List<ErrorType> errors = new ArrayList<>();
    private static ErrorHandler instance = null;

    public static ErrorHandler getInstance() {
        if(instance == null) {
            instance = new ErrorHandler();
        }

        return instance;
    }

    public boolean anyError() {
        return this.errors.size() > 0;
    }

    public void showErrors(PrintStream printStream) {
        errors.forEach(printStream::println);
    }

    public void addError(ErrorType errorType) {
        errors.add(errorType);
    }
}
