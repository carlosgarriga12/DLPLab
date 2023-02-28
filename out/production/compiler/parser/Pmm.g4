grammar Pmm;	

@header{
    import ast.definition.*;
    import ast.expression.*;
    import ast.statement.*;
    import ast.type.*;
    import parser.LexerHelper;
    import ast.*;
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

varDefinition returns [List<VariableDefinition> ast = new ArrayList<>()] locals [List<Token> aux = new ArrayList<>()]:
        ID { $aux.add($ID);}
        (',' ID { $aux.add($ID);} )* ':' type ';'
        //
        {$aux.forEach(token -> $ast.add(new VariableDefinition(
                token.getLine(),
                token.getCharPositionInLine() + 1,
                $type.ast,
                token.getText()
        )));}
        ;

functionDefinition returns[Definition ast] locals [List<Statement> statements = new ArrayList<>()]:
                START='def' ID '(' parameters ')'':' built_in_type
                '{' (varDefinition {$statements.addAll($varDefinition.ast);} )*
                    (statement {$statements.add($statement.ast);} )* '}'
                {$ast = new FunctionDefinition(
                                           $START.getLine(),
                                           $START.getCharPositionInLine() + 1,
                                           new FunctionType(0, 0, $parameters.ast, $built_in_type.ast),
                                           $ID.text,
                                           $statements
                                       );}
                | START='def' ID '(' parameters ')'':'
                '{' (varDefinition {$statements.addAll($varDefinition.ast);} )*
                    (statement {$statements.add($statement.ast);} )* '}'
                {$ast = new FunctionDefinition(
                                           $START.getLine(),
                                           $START.getCharPositionInLine() + 1,
                                           new FunctionType(0, 0, $parameters.ast, VoidType.getInstance()),
                                           $ID.text,
                                           $statements
                                       );}
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

type returns [Type ast]:
    built_in_type                   {$ast = $built_in_type.ast;}
    | START='[' INT_CONSTANT ']' type     {$ast = new ArrayType(
                                                        $START.getLine(),
                                                        $START.getCharPositionInLine() + 1,
                                                        $type.ast,
                                                        LexerHelper.lexemeToInt($INT_CONSTANT.text)
                                                     );}
    | START = 'struct' '{' recordFields '}'     {$ast = new RecordType(
                                                            $START.getLine(),
                                                            $START.getCharPositionInLine() + 1,
                                                            $recordFields.ast
                                                        );}
    ;

recordFields returns [List<RecordField> ast = new ArrayList<>()]:
    (recordField { $ast.add($recordField.ast); } )+
    ;

recordField returns [RecordField ast]:
        ID ':' type ';' {$ast = new RecordField(
                                        $ID.getLine(),
                                        $ID.getCharPositionInLine() + 1,
                                        $type.ast,
                                        $ID.text
                                   );}
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
        | ID '(' ')'
        {$ast = new FunctionInvocation(
            $ID.getLine(),
            $ID.getCharPositionInLine() + 1,
            new Variable($ID.getLine(),
                         $ID.getCharPositionInLine() + 1,
                         $ID.text),
            new ArrayList<>()
        );}
        //Variable
        | ID
        {$ast = new Variable(
            $ID.getLine(),
            $ID.getCharPositionInLine() + 1,
            $ID.text
        );}

        //Parenthesis
        | '(' expression ')'
        {$ast = $expression.ast; }

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
        | START='(' built_in_type ')' expression
        {$ast = new Cast(
            $START.getLine(),
            $START.getCharPositionInLine() + 1,
            $built_in_type.ast,
            $expression.ast
         );}

        //UnaryMinus
        | '-' expression
        {$ast = new UnaryMinus(
            $expression.ast.getLine(),
            $expression.ast.getColumn(),
            $expression.ast
        );}

        //Not
        | '!' expression
        {$ast = new Not(
                $expression.ast.getLine(),
                $expression.ast.getColumn(),
                $expression.ast
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

        //Logical
        | exp1=expression OP=('<' | '<=' | '==' |'>=' | '>' | '!=') exp2=expression
        {$ast = new Logical(
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
         START='while' expression ':' body            {$ast = new While(
                                                                $START.getLine(),
                                                                $START.getCharPositionInLine() + 1,
                                                                $expression.ast,
                                                                $body.ast
                                                              );}

        //IfElse
        | START='if' expression ':' body              {$ast = new IfElse(
                                                                $START.getLine(),
                                                                $START.getCharPositionInLine() + 1,
                                                                $expression.ast,
                                                                $body.ast,
                                                                new ArrayList<Statement>()
                                                              );}

        | START='if' expression ':' ifStmts=body 'else' ':' elseStmts=body     {$ast = new IfElse(
                                                                                    $START.getLine(),
                                                                                    $START.getCharPositionInLine() + 1,
                                                                                    $expression.ast,
                                                                                    $ifStmts.ast,
                                                                                    $elseStmts.ast
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
        | ID '(' ')' ';'                            {$ast = new FunctionInvocation(
                                                                    $ID.getLine(),
                                                                    $ID.getCharPositionInLine() + 1,
                                                                    new Variable(
                                                                            $ID.getLine(),
                                                                            $ID.getCharPositionInLine() + 1,
                                                                            $ID.text),
                                                                    new ArrayList<>()
                                                              );}
        ;

body returns [List<Statement> ast = new ArrayList<>()]:
              statement {$ast.add($statement.ast);}
        | '{' (statement {$ast.add($statement.ast);} )* '}'
        ;

expressions returns[List<Expression> ast = new ArrayList<>()]:
        ( exp1=expression {$ast.add($exp1.ast); } (',' exp2=expression {$ast.add($exp2.ast);} )* )
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

ONE_LINE_COMMENT: '#' ~('\n')*? ('\n'| EOF) -> skip
                ;

MULTILINE_COMMENT: THREE_APOSTROPHE (.)*? THREE_APOSTROPHE -> skip
                ;

TRASH: [\n\r\t ]+ -> skip
    ;