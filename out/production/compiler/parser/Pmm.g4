grammar Pmm;	

program: definition*  main_function EOF
       ;

main_function: 'def' 'main' '(' ')'':' '{' varDefinition* statement* '}'
            ;

//------------- Parser ----------------

//Definitions
definition: varDefinition | functionDefinition
        ;

varDefinition: ID (',' ID)* ':' type ';'
            ;

functionDefinition: 'def' ID '(' (parameter (',' parameter )*)? ')'':' built_in_type? '{' varDefinition* statement* '}'
                ;

parameter: ID ':' type
        ;

built_in_type: 'int' | 'char' | 'double'
            ;

type: built_in_type
    | '[' INT_CONSTANT ']' type
    | 'struct' '{' structField+ '}'
    ;

structField: ID ':' type ';'
    ;

//Expressions
expression: INT_CONSTANT
        | CHAR_CONSTANT
        | REAL_CONSTANT
        | ID '(' (expression (','expression)* | ) ')' //FunctionInvocation
        | ID                                          //Identifiers
        | '(' expression ')'                          //Parenthesis
        | expression '[' expression ']'               //ArrayAccess
        | expression '.' ID                           //FieldAccess
        | '(' ('int' | 'char'| 'double' ) ')'
            expression                                //Cast
        | '-' expression                              //UnaryMinus
        | '!' expression                              //Not
        | expression ('*'|'/'|'%') expression         //Arithmetic
        | expression ('+'|'-') expression
        | expression ('<' | '<=' | '==' |
            '>=' | '>' | '!=')
          expression                                  //Logical
        | expression ('&&' | '||') expression
         ;

//Statements
statement: 'while' expression ':' body                    //While
        | 'if' expression ':' body ('else' ':' body)?     //IfElse
        | expression '=' expression ';'                   //Assignment
        | 'return' expression ';'                         //Return
        | 'print' (expression (',' expression)*) ';'      //Print
        | 'input' (expression (',' expression)*) ';'      //Read
        | ID '(' (expression (','expression)* | ) ')' ';' //FunctionInvocation as a statement
        | varDefinition                                   //Variable definition
        ;

body: (statement | '{' statement* '}')
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