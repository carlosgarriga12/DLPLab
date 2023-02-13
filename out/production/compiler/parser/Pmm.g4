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

REAL_CONSTANT: INT_CONSTANT '.' INT_CONSTANT
            | INT_CONSTANT '.'
            | '.' INT_CONSTANT
            ;

mantissa:
        ;

TRASH: [\n\r\t] -> skip
    ;