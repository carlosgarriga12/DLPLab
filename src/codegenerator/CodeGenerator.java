package codegenerator;

import ast.expression.Arithmetic;
import ast.expression.Comparison;
import ast.type.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CodeGenerator {
    private PrintWriter out;
    private String inputFile;
    private String outputFile;
    private int label;

    public CodeGenerator(String outputFile, String inputFile) {
        try {
            out = new PrintWriter(outputFile);
            this.inputFile = inputFile;
            this.outputFile = outputFile;
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        out.write("#SOURCE \"" + this.inputFile + "\"" + "\n");
        newLine();
        out.flush();
    }

    public int nextLabel() {
        return this.label++;
    }

    public void mainProgram() {
        out.write("' * Invocation to the main function" + "\n");
        out.write("call main\n");
        out.write("halt\n\n");
        out.flush();
    }

    public void in(Type type) {
        out.write("\tin" + type.suffix() + "\n");
        out.flush();
    }

    public void store(Type type) {
        out.write("\tstore" + type.suffix() + "\n");
        out.flush();
    }

    public void pushAddress(int offset) {
        out.write("\tpusha " + offset + "\n");
        out.flush();
    }

    public void pushBP() {
        out.write("\tpush bp" + "\n");
        out.flush();
    }

    public void pushi(int offset) {
        out.write("\tpushi " + offset + "\n");
        out.flush();
    }

    public void add(char suffix) {
        String auxSuffix = suffix != 'b'? String.valueOf(suffix) : "";
        out.write("\tadd" + auxSuffix + "\n");
        out.flush();
    }

    public void sub(char suffix) {
        String auxSuffix = suffix != 'b'? String.valueOf(suffix) : "";
        out.write("\tsub" + auxSuffix + "\n");
        out.flush();
    }

    public void mul(char suffix) {
        String auxSuffix = suffix != 'b'? String.valueOf(suffix) : "";
        out.write("\tmul" + auxSuffix + "\n");
        out.flush();
    }

    public void div(char suffix) {
        String auxSuffix = suffix != 'b'? String.valueOf(suffix) : "";
        out.write("\tdiv" + auxSuffix + "\n");
        out.flush();
    }


    public void out(Type type) {
        out.write("\tout" + type.suffix() + "\n");
        out.flush();
    }

    public void load(Type type) {
        out.write("\tload" + type.suffix() + "\n");
        out.flush();
    }

    public void promotion(Type typeBase, Type typeToConvert) {
        if(typeBase.equals(IntType.getInstance())) {
            if (typeToConvert.equals(CharType.getInstance())) {
                out.write("\ti2b" + "\n");
            } else if (typeToConvert.equals(RealType.getInstance())) {
                out.write("\ti2f" + "\n");
            }
        } else if(typeBase.equals(RealType.getInstance())){
            if(typeToConvert.equals(IntType.getInstance())) {
                out.write("\tf2i" + "\n");
            } else if(typeToConvert.equals(CharType.getInstance())) {
                out.write("\tf2i" + "\n" + "\ti2b" + "\n");
            }
        } else if (typeBase.equals(CharType.getInstance())) {
            if(typeToConvert.equals(IntType.getInstance())) {
                out.write("\tb2i" + "\n");
            } else if(typeToConvert.equals(RealType.getInstance())) {
                out.write("\tb2i" + "\n" + "\ti2f" + "\n");
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
            case "%":
                mod(arithmetic.type.suffix());
                break;

        }
    }

    private void mod(char suffix) {
        String auxSuffix = suffix != 'b'? String.valueOf(suffix) : "";
        out.write("\tmod" + auxSuffix + "\n");
        out.flush();
    }

    public void pushb(int value) {
        out.write("\tpushb " + value + "\n");
        out.flush();
    }

    public void pushf(double value) {
        out.write("\tpushf " + value + "\n");
        out.flush();
    }

    public void logical(String operator) {
        if(operator.equals("&&")) {
            out.write("\tand" + "\n");
        } else {
            out.write("\tor" + "\n");
        }
        out.flush();
    }

    public void not() {
        out.write("\tnot" + "\n");
        out.flush();
    }

    public void push(Type type, String s) {
        out.write("\tpush" + type.suffix() + " " + s + "\n");
        out.flush();
    }

    public void addComment(String s) {
        out.write("\t'" + s + "\n");
        out.flush();
    }

    public void label(String name) {
        out.write(" " + name + ":" + "\n");
        out.flush();
    }

    public void enter(int byteLocals) {
        out.write("\tenter " + byteLocals + "\n");
        out.flush();
    }

    public void ret(int bytesReturn, int byteLocals, int byteParameters) {
        out.write("\tret " + bytesReturn  + ", " + byteLocals + ", " + byteParameters + "\n");
        out.flush();
    }

    public void newLine() {
        out.write("\n");
        out.flush();
    }

    public void comparison(Comparison comparison, Type highestType) {
        switch (comparison.operator) {
            case "<=":
                out.write("\tle" + highestType.suffix() + "\n");
                break;
            case "<":
                out.write("\tlt" + highestType.suffix() + "\n");
                break;
            case "==":
                out.write("\teq" + highestType.suffix() + "\n");
                break;
            case ">":
                out.write("\tgt" + highestType.suffix() + "\n");
                break;
            case ">=":
                out.write("\tge" + highestType.suffix() + "\n");
                break;
            case "!=":
                out.write("\tne" + highestType.suffix() + "\n");
                break;
        }
        out.flush();

    }

    public void call(String name) {
        out.write("\tcall " + name + "\n");
        out.flush();
    }

    public void pop(char suffix) {
        String auxSuffix = suffix != 'b'? String.valueOf(suffix) : "";
        out.write("\tpop" + auxSuffix + "\n");
        out.flush();
    }

    public void jumpIfZero(int elseLabel) {
        out.write("\tjz " + "label" + elseLabel + "\n");
        out.flush();
    }


    public void jump(int exitLabel) {
        out.write("\tjmp " + "label" + exitLabel + "\n");
        out.flush();
    }

    public void putLabel(int label) {
        out.write(" label" + label + ":" + "\n");
        out.flush();
    }

    public void writeLine(int line) {
        out.write("#line\t" + line + "\n");
        out.flush();
    }

    public Type highestType(Type type, Type otherType) {
        if(type instanceof CharType) {
            if(otherType instanceof IntType) {
                return IntType.getInstance();
            }
            if(otherType instanceof RealType) {
                return RealType.getInstance();
            }
            if(otherType instanceof CharType) {
                return IntType.getInstance();
            }
        }
        if(type instanceof IntType) {
            if(otherType instanceof IntType) {
                return IntType.getInstance();
            }
            if(otherType instanceof RealType) {
                return RealType.getInstance();
            }
            if(otherType instanceof CharType) {
                return IntType.getInstance();
            }
        }
        return RealType.getInstance();
    }
}
