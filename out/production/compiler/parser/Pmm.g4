grammar Pmm;	

program: INT_CONSTANT
        | CHAR_CONSTANT
        | REAL_CONSTANT
        | ID
       ;
  		 
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

fragment MANTISSA: (FLOATING_POINT | INT_CONSTANT) ('e'|'E') ('-')? INT_CONSTANT
        ;

fragment LETTER: [a-z] | [A-Z]
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