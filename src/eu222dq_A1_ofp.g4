/**
 * Define a grammar called ofp
 */
grammar eu222dq_A1_ofp;

@header {    // Define name of package for generated Java files. 
    package generated;
}

// Syntax specification --> Context-free grammar

program : funcDecl* main funcDecl* ;

main : 'void' 'main' '()' block ;

funcDecl : (TYPE | 'void') ID '(' paramList? ')' block ;

block : '{' stmt* '}' ;

paramList : TYPE ID (',' TYPE ID)* ;

stmt
    : declaration
    | assignment
    | funcCall ';'
    | 'while' '(' expr ')' block
    | 'print' '(' expr ')' ';'
    | 'println' '(' expr')' ';'
    | 'return' expr? ';'
    | 'if' '(' expr ')' stmt ('else' stmt)?
    | block
    ;

expr
    : '(' expr ')'
    | '-' expr
    | expr ('*' | '/') expr
    | expr ('+' | '-') expr
    | expr ('>' | '<') expr
    | expr ('==') expr
    | expr '.' 'length'
    | access
    | funcCall
    | 'new' TYPE '[' expr ']'
    | '{' argList '}'
    | INT
    | FLOAT
    | BOOL
    | CHAR
    | STRING
    | ID
    ;

access
    : ID '[' expr ']'
    ;

assignment
    : ID ('[' expr ']')? '=' expr ';'
    ;

declaration
    : TYPE ID ('=' expr)? ';'
    ;

funcCall
    : ID '(' argList ')'
    ;

argList : (expr (',' expr)*)? ;

// Tokens and Lexer rules

TYPE 
    : 'int' '[]'?
    | 'float' '[]'?
    | 'bool'
    | 'char' '[]'?
    | 'string'
    ;


INT : '0'| ('1'..'9')('0'..'9')* ;
FLOAT : INT '.' [0-9]+ ;
BOOL : 'true' | 'false' ;
CHAR : '\'' [a-zA-Z!.,?=:() ]? '\'' ;
STRING : '"' [a-zA-Z!.,?=:() ]* '"' ;

ID : [a-zA-Z] [a-zA-Z]* ;

WS : [ \t\r\n]+ -> skip ;
COMMENT : '#' ~[\r\n]* -> skip ;