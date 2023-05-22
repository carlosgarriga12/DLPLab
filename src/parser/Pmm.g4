grammar Pmm;	

@header{
    import ast.definition.*;
    import ast.expression.*;
    import ast.statement.*;
    import ast.type.*;
    import parser.LexerHelper;
    import ast.*;
    import java.util.stream.Collectors;
}

program returns [Program ast]
            locals [List<Definition> aux = new ArrayList<>()]:
            (definition {$aux.addAll($definition.ast);})*
            main_function {$aux.add($main_function.ast);} EOF
            {$ast = new Program(0,0, $aux);}
       ;

main_function returns [Definition ast] locals [List<Statement> statements = new ArrayList<>()]:
                START='def' 'main' '(' ')'':' '{' (varDefinition {$statements.addAll($varDefinition.ast);} )*
                (statement {$statements.add($statement.ast);} )* '}'
                {
                    $ast = new FunctionDefinition(
                               $START.getLine(),
                               $START.getCharPositionInLine() + 1,
                               new FunctionType(0, 0, new ArrayList<>(), VoidType.getInstance()),
                               "main",
                               $statements
                           );}
            ;

//------------- Parser ----------------

//Definitions
definition returns [List<Definition> ast = new ArrayList<>()]:
            (varDefinition {$ast.addAll($varDefinition.ast);}
            | functionDefinition {$ast.add($functionDefinition.ast); })
        ;

varDefinition returns [List<VariableDefinition> ast = new ArrayList<>()]
              locals [List<Token> aux = new ArrayList<>()]:
        ID1=ID { $aux.add($ID1);}
        (',' ID2=ID { $aux.add($ID2);} )* ':' type ';'
        //
        {$aux.forEach(token -> $ast.add(new VariableDefinition(
                token.getLine(),
                token.getCharPositionInLine() + 1,
                $type.ast,
                token.getText()
        )));}

        {
                for(int i = 0; i < $aux.size() - 1; i++) {
                    VariableDefinition varDef = $ast.get(i);
                    for(int j = i + 1; j < $aux.size(); j++) {
                        if (varDef.getName().equals($ast.get(j).getName())) {
                            new ErrorType(
                                $ast.get(j).getLine(),
                                $ast.get(j).getColumn(),
                                "Repeated variable definition " + $ast.get(j).getName()
                            );
                        }
                    }
                }
        }
        ;

functionDefinition returns[Definition ast] locals [List<Statement> statements = new ArrayList<>()]:
                START='def' ID '(' parameters ')'':' built_in_type
                '{' (varDefinition {$statements.addAll($varDefinition.ast);} )*
                    (statement {$statements.add($statement.ast);} )* '}'
                {

                FunctionDefinition funcDef = new FunctionDefinition(
                                                $START.getLine(),
                                                $START.getCharPositionInLine() + 1,
                                                new FunctionType(0, 0, $parameters.ast, $built_in_type.ast),
                                                $ID.text,
                                                $statements
                                            );
                funcDef.addParameters($parameters.ast);
                $ast = funcDef;}
                | START='def' ID '(' parameters ')'':'
                '{' (varDefinition {$statements.addAll($varDefinition.ast);} )*
                    (statement {$statements.add($statement.ast);} )* '}'
                {
                FunctionDefinition funcDef = new FunctionDefinition(
                                                    $START.getLine(),
                                                    $START.getCharPositionInLine() + 1,
                                                    new FunctionType(0, 0, $parameters.ast, VoidType.getInstance()),
                                                    $ID.text,
                                                    $statements
                                                );

                funcDef.addParameters($parameters.ast);
                $ast = funcDef;
                }
                ;


parameters returns [List<VariableDefinition> ast = new ArrayList<>()]:
        parameter {$ast.add($parameter.ast);} (',' parameter {$ast.add($parameter.ast);} )*
        |
        ;

parameter returns [VariableDefinition ast]:
        ID ':' type {$ast = new VariableDefinition(
                                    $ID.getLine(),
                                    $ID.getCharPositionInLine() + 1,
                                    $type.ast,
                                    $ID.text
                               );}
        ;

built_in_type returns [Type ast]:
              'int'     {$ast = IntType.getInstance();}
            | 'char'    {$ast = CharType.getInstance();}
            | 'double'  {$ast = RealType.getInstance();}
            ;

type returns [Type ast] locals [List<RecordField> recordFields = new ArrayList<>()]:
    built_in_type                   {$ast = $built_in_type.ast;}
    | START='[' INT_CONSTANT ']' t=type     {$ast = new ArrayType(
                                                        $START.getLine(),
                                                        $START.getCharPositionInLine() + 1,
                                                        $t.ast,
                                                        LexerHelper.lexemeToInt($INT_CONSTANT.text)
                                                     );}

    |
        START = 'struct' '{' (r=recordField {$recordFields.addAll($r.ast); } )* '}'
            {
                for(int i = 0; i < $recordFields.size() - 1 ; i++) {
                    RecordField r = $recordFields.get(i);
                    for (int j = i + 1; j < $recordFields.size(); j++) {
                        if(r.name.equals($recordFields.get(j).name)) {
                            ErrorType error = new ErrorType
                            (
                                $recordFields.get(j).getLine(),
                                $recordFields.get(j).getColumn(),
                                "Repeated field " + $recordFields.get(j).name + " for struct"
                            );
                        }
                    }
                }
            }

         {$ast = new RecordType(
                $START.getLine(),
                $START.getCharPositionInLine() + 1,
                $recordFields
            );}
    ;

recordField returns [List<RecordField> ast = new ArrayList<>()]
            locals [List<Token> aux = new ArrayList<>()]:
        ID { $aux.add($ID);}
                (',' ID { $aux.add($ID);} )* ':' type ';'
                //
                {$aux.forEach(token -> $ast.add(new RecordField(
                        token.getLine(),
                        token.getCharPositionInLine() + 1,
                        $type.ast,
                        token.getText()
                )));}

        ;

//Expressions
expression returns [Expression ast]:
        //INT_CONSTANT
        INT_CONSTANT
        {$ast = new IntLiteral(
            $INT_CONSTANT.getLine(),
            $INT_CONSTANT.getCharPositionInLine() + 1,
            LexerHelper.lexemeToInt($INT_CONSTANT.text)
         );}
        //CHAR_CONSTANT
        | CHAR_CONSTANT
        {$ast = new CharLiteral(
            $CHAR_CONSTANT.getLine(),
            $CHAR_CONSTANT.getCharPositionInLine() + 1,
            LexerHelper.lexemeToChar($CHAR_CONSTANT.text)
         );}
        //REAL_CONSTANT
        | REAL_CONSTANT
        {$ast = new RealLiteral(
            $REAL_CONSTANT.getLine(),
            $REAL_CONSTANT.getCharPositionInLine() + 1,
            LexerHelper.lexemeToReal($REAL_CONSTANT.text)
         );}
        //FunctionInvocation
        | ID '(' expressions ')'
        {$ast = new FunctionInvocation(
            $ID.getLine(),
            $ID.getCharPositionInLine() + 1,
            new Variable($ID.getLine(),
                         $ID.getCharPositionInLine() + 1,
                         $ID.text),
            $expressions.ast
        );}

        //Variable
        | ID
        {$ast = new Variable(
            $ID.getLine(),
            $ID.getCharPositionInLine() + 1,
            $ID.text
        );}

        //Parenthesis
        | '(' exp1=expression ')'
        {$ast = $exp1.ast; }

        //ArrayAccess
        | exp1=expression '[' exp2=expression ']'
        {$ast = new ArrayAccess(
              $exp1.ast.getLine(),
              $exp1.ast.getColumn(),
              $exp1.ast,
              $exp2.ast
          );}

        //FieldAccess
        | e1=expression '.' ID
        {$ast = new FieldAccess(
            $e1.ast.getLine(),
            $e1.ast.getColumn(),
            $e1.ast,
            $ID.text
         );}

        //Cast
        | START='(' b=built_in_type ')' exp1=expression
        {$ast = new Cast(
            $START.getLine(),
            $START.getCharPositionInLine() + 1,
            $b.ast,
            $exp1.ast
         );}

        //UnaryMinus
        | '-' exp1=expression
        {$ast = new UnaryMinus(
            $exp1.ast.getLine(),
            $exp1.ast.getColumn(),
            $exp1.ast
        );}

        //Not
        | '!' exp1=expression
        {$ast = new Not(
                $exp1.ast.getLine(),
                $exp1.ast.getColumn(),
                $exp1.ast
              );}

        //Arithmetic
        | exp1=expression OP=('*'|'/'|'%') exp2=expression
        {$ast = new Arithmetic(
                $exp1.ast.getLine(),
                $exp1.ast.getColumn(),
                $exp1.ast,
                $exp2.ast,
                $OP.text
              );}

        | exp1=expression OP=('+'|'-') exp2=expression
        {$ast = new Arithmetic(
                $exp1.ast.getLine(),
                $exp1.ast.getColumn(),
                $exp1.ast,
                $exp2.ast,
                $OP.text
              );}

        //Comparison
        | exp1=expression OP=('<' | '<=' | '==' |'>=' | '>' | '!=') exp2=expression
        {$ast = new Comparison(
                 $exp1.ast.getLine(),
                 $exp1.ast.getColumn(),
                 $exp1.ast,
                 $exp2.ast,
                 $OP.text
               );}

        | exp1=expression OP=('&&' | '||') exp2=expression
        {$ast = new Logical(
                 $exp1.ast.getLine(),
                 $exp1.ast.getColumn(),
                 $exp1.ast,
                 $exp2.ast,
                 $OP.text
              );}
         ;

//Statements
statement returns [Statement ast]:
         //While
         START='while' exp=expression ':' body            {$ast = new While(
                                                                $START.getLine(),
                                                                $START.getCharPositionInLine() + 1,
                                                                $exp.ast,
                                                                $body.ast
                                                              );}

        //IfElse
        |   {List<Statement> elseStatements = new ArrayList<>();}
            START='if' exp=expression ':' ifStmts=body ('else' ':' elseStmts=body {elseStatements = $elseStmts.ast;})?

                                                                                {$ast = new IfElse(
                                                                                    $START.getLine(),
                                                                                    $START.getCharPositionInLine() + 1,
                                                                                    $exp.ast,
                                                                                    $ifStmts.ast,
                                                                                    elseStatements
                                                                                  );}
        //Assignment
        | exp1=expression '=' exp2=expression ';'         {$ast = new Assignment(
                                                                        $exp1.ast.getLine(),
                                                                        $exp1.ast.getColumn(),
                                                                        $exp1.ast,
                                                                        $exp2.ast
                                                                      );}
        //Return
        | START='return' expression ';'                         {$ast = new Return(
                                                                        $START.getLine(),
                                                                        $START.getCharPositionInLine() + 1,
                                                                        $expression.ast
                                                                      );}
        //Print
        | START='print' expressions ';'             {$ast = new Print(
                                                        $START.getLine(),
                                                        $START.getCharPositionInLine() + 1,
                                                        $expressions.ast
                                                     );}

        //Read
        | START='input' expressions ';'            {$ast = new Read(
                                                        $START.getLine(),
                                                        $START.getCharPositionInLine() + 1,
                                                        $expressions.ast
                                                     );}
        //FunctionInvocation as a statement
        | ID '(' expressions ')' ';'               {$ast = new FunctionInvocation(
                                                                    $ID.getLine(),
                                                                    $ID.getCharPositionInLine() + 1,
                                                                    new Variable(
                                                                            $ID.getLine(),
                                                                            $ID.getCharPositionInLine() + 1,
                                                                            $ID.text),
                                                                    $expressions.ast
                                                              );}
        ;

body returns [List<Statement> ast = new ArrayList<>()]:
              st1=statement {$ast.add($st1.ast);}
        | '{' (st2=statement {$ast.add($st2.ast);} )* '}'
        ;

expressions returns[List<Expression> ast = new ArrayList<>()]:
        ( exp1=expression {$ast.add($exp1.ast); } (',' exp2=expression {$ast.add($exp2.ast);} )* | /* Epsilon */{$ast = $ast;} )
        ;

//------------- Lexer -----------------

INT_CONSTANT: '0'
            | [1-9][0-9]*
            ;

CHAR_CONSTANT: '\'' . '\''
            | '\'' '\\' INT_CONSTANT '\''
            | '\'' '\\' [nt] '\''
            ;

REAL_CONSTANT: FLOATING_POINT
             | MANTISSA
             ;

fragment FLOATING_POINT: INT_CONSTANT '.' INT_CONSTANT
            | INT_CONSTANT '.'
            | '.' INT_CONSTANT
            ;

fragment MANTISSA: (FLOATING_POINT | INT_CONSTANT) ('e'|'E') [+-]? INT_CONSTANT
        ;

fragment LETTER: [a-zA-Z]
        ;

fragment DIGIT: [0-9]
        ;

fragment THREE_APOSTROPHE: '"""'
                        ;
ID: (LETTER |'_') (LETTER | DIGIT| '_')*
        ;

ONE_LINE_COMMENT: '#' .*? ('\n'| EOF) -> skip
                ;

MULTILINE_COMMENT: THREE_APOSTROPHE .*? THREE_APOSTROPHE -> skip
                ;

TRASH: (' '|'\n'|'\r'|'\t') + -> skip
    ;