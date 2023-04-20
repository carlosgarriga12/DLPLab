package codegenerator;

import ast.expression.Arithmetic;
import ast.expression.Logical;
import ast.type.CharType;
import ast.type.IntType;
import ast.type.RealType;
import ast.type.Type;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CodeGenerator {
    private PrintWriter out;
    private String inputFile;
    private String outputFile;

    public CodeGenerator(String outputFile, String inputFile) {
        try {
            out = new PrintWriter(outputFile);
            this.inputFile = inputFile;
            this.outputFile = outputFile;
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        out.write("#SOURCE \"" + this.inputFile + "\"" + "\n");
        out.flush();
    }


    public void mainProgram() {
        out.write("call main\n");
        out.write("halt\n\n");
        out.flush();
    }

    public void in(Type type) {
        out.write("in" + type.suffix() + "\n");
        out.flush();
    }

    public void store(Type type) {
        out.write("store" + type.suffix() + "\n");
        out.flush();
    }

    public void pushAddress(int offset) {
        out.write("pusha " + offset + "\n");
        out.flush();
    }

    public void pushBP() {
        out.write("push bp" + "\n");
        out.flush();
    }

    public void pushi(int offset) {
        out.write("pushi " + offset + "\n");
        out.flush();
    }

    public void add(char suffix) {
        String auxSuffix = suffix == 'b'? String.valueOf(suffix) : "";
        out.write("add" + auxSuffix + "\n");
        out.flush();
    }

    public void sub(char suffix) {
        String auxSuffix = suffix == 'b'? String.valueOf(suffix) : "";
        out.write("sub" + auxSuffix + "\n");
        out.flush();
    }

    public void mul(char suffix) {
        String auxSuffix = suffix == 'b'? String.valueOf(suffix) : "";
        out.write("mul" + auxSuffix + "\n");
        out.flush();
    }

    public void div(char suffix) {
        String auxSuffix = suffix == 'b'? String.valueOf(suffix) : "";
        out.write("div" + auxSuffix + "\n");
        out.flush();
    }


    public void out(Type type) {
        out.write("out" + type.suffix() + "\n");
        out.flush();
    }

    public void load(Type type) {
        out.write("load" + type.suffix() + "\n");
        out.flush();
    }

    public void promotion(Type typeBase, Type typeToConvert) {

        if(typeBase.equals(IntType.getInstance())) {
            if (typeToConvert.equals(CharType.getInstance())) {
                out.write("i2b" + "\n");
            } else if (typeToConvert.equals(RealType.getInstance())) {
                out.write("i2f" + "\n");
            }
        } else if(typeBase.equals(RealType.getInstance())){
            if(typeToConvert.equals(IntType.getInstance())) {
                out.write("f2i" + "\n");
            } else if(typeToConvert.equals(CharType.getInstance())) {
                out.write("f2i" + "\n" + "i2b" + "\n");
            }
        } else if (typeBase.equals(CharType.getInstance())) {
            if(typeToConvert.equals(IntType.getInstance())) {
                out.write("b2i" + "\n");
            } else if(typeToConvert.equals(RealType.getInstance())) {
                out.write("b2i" + "\n" + "i2f" + "\n");
            }
        }
        out.flush();
    }

    public void arithmetic(Arithmetic arithmetic) {
        switch (arithmetic.operator) {
            case "+":
                add(arithmetic.type.suffix());
                break;
            case "-":
                sub(arithmetic.type.suffix());
                break;
            case "*":
                mul(arithmetic.type.suffix());
                break;
            case "/":
                div(arithmetic.type.suffix());
                break;
        }
    }

    public void pushb(int value) {
        out.write("pushb " + value + "\n");
        out.flush();
    }

    public void pushf(double value) {
        out.write("pushf " + value + "\n");
        out.flush();
    }

    public void logical(String operator) {
        if(operator.equals("&&")) {
            out.write("and" + "\n");
        } else {
            out.write("or" + "\n");
        }
        out.flush();
    }

    public void not() {
        out.write("not" + "\n");
        out.flush();
    }

    public void push(Type type, String s) {
        out.write("push" + type.suffix() + " " + s + "\n");
        out.flush();
    }

    public void addComment(String s) {
        out.write("'" + s + "\n");
        out.flush();
    }

    public void label(String name) {
        out.write(name + ":" + "\n");
        out.flush();
    }

    public void enter(int byteLocals) {
        out.write("enter " + byteLocals + "\n");
        out.flush();
    }

    public void ret(int bytesReturn, int byteLocals, int byteParameters) {
        out.write("ret " + bytesReturn  + ", " + byteLocals + ", " + byteParameters + "\n");
        out.flush();
    }
}
