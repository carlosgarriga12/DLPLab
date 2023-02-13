grammar Pmm;	

program: CHAR_CONSTANT
       ;
  		 
INT_CONSTANT: '0'
            | [1-9][0-9]*
            ;

CHAR_CONSTANT: '\'' . '\''
            | '\'' '\\' INT_CONSTANT '\''
            | '\'' '\\' 'n' '\''
            | '\'' '\\' 't' '\''
            ;

REAL_CONSTANT: FLOATING_POINT
             | MANTISSA
             ;

fragment FLOATING_POINT: INT_CONSTANT '.' INT_CONSTANT
            | INT_CONSTANT '.'
            | '.' INT_CONSTANT
            ;

fragment MANTISSA: (FLOATING_POINT | INT_CONSTANT) ('e'|'E') '-' INT_CONSTANT
        ;

ONE_LINE_COMMENT: '#' ~('\n')* '\n'
                ;

TRASH: [\n\r\t ] -> skip
    ;