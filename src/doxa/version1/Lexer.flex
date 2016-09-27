package doxa.version1;

/**	Projeto Compiladores Linguagem Doxa
	@author Ikaro Alef e Kenedy Felipe
*/

%%

%class Lexer
%public
%type Token
%function nextToken
%line
%column

whiteSpace=([ \n\t\f\r]+)
identificador=[a-z]([a-zA-Z_]|[0-9])*
inteiro=[0-9]+
reais=[0-9]*"."[0-9]+|[0-9]+"."[0-9]*
caracter = ('[0-9]'|'[a-zA-Z]'|'\\n'|'\\t'|' '|'\ '|':'|'\('|'\)'|',')

%%

// Caracteres Brancos
{whiteSpace} { 
	// Caracteres ignorados.
	// Nenhum token é retornado.
}

{caracter}+ { return new Token(TokenType.CHAR_LITERAL, yytext(), yyline, yycolumn); }

// Operadores Relacionais
"<" { return new Token(TokenType.MENOR_QUE, yyline, yycolumn); }
">" { return new Token(TokenType.MAIOR_QUE, yyline, yycolumn); }
"<=" { return new Token(TokenType.MENOR_IGUAL, yyline, yycolumn); }
">=" { return new Token(TokenType.MAIOR_IGUAL, yyline, yycolumn); }
"=" { return new Token(TokenType.IGUAL, yyline, yycolumn); }
"<>" { return new Token(TokenType.DIFERENTE, yyline, yycolumn); }

// Operadores Logico-Aritmeticos
"+" { return new Token(TokenType.MAIS, yyline, yycolumn); }
"-" { return new Token(TokenType.MENOS, yyline, yycolumn); }
"*" { return new Token(TokenType.VEZES, yyline, yycolumn); }
"/" { return new Token(TokenType.DIVISAO, yyline, yycolumn); }
"%" { return new Token(TokenType.MODULO, yyline, yycolumn); }
and { return new Token(TokenType.AND, yyline, yycolumn); }
or { return new Token(TokenType.OR, yyline, yycolumn); }
not { return new Token(TokenType.NOT, yyline, yycolumn); }

// Operador de Atribuição
":=" { return new Token(TokenType.ATRIBUICAO, yyline, yycolumn); }

// Simbolos Especiais
")" { return new Token(TokenType.FECHA_PAR, yyline, yycolumn); }
"(" { return new Token(TokenType.ABRE_PAR, yyline, yycolumn); }
"," { return new Token(TokenType.VIRGULA, yyline, yycolumn); }
";" { return new Token(TokenType.PT_VIRG, yyline, yycolumn); }
"{" { return new Token(TokenType.ABRE_CHAVES, yyline, yycolumn); }
"}" { return new Token(TokenType.FECHA_CHAVES, yyline, yycolumn); }

// Palavras-chave Reservadas
if { return new Token(TokenType.IF, yyline, yycolumn); }
else { return new Token(TokenType.ELSE, yyline, yycolumn); }
while { return new Token(TokenType.WHILE, yyline, yycolumn); }
return { return new Token(TokenType.RETURN, yyline, yycolumn); }
float { return new Token(TokenType.FLOAT, yyline, yycolumn); }
char { return new Token(TokenType.CHAR, yyline, yycolumn); }
void { return new Token(TokenType.VOID, yyline, yycolumn); }
prnt { return new Token(TokenType.PRNT, yyline, yycolumn); }
int { return new Token(TokenType.INT, yyline, yycolumn); }
proc { return new Token(TokenType.PROC, yyline, yycolumn); }
var { return new Token(TokenType.VAR, yyline, yycolumn); }

// Identificador
{identificador}+   { return new Token(TokenType.IDENTIFICADOR, yytext(), yyline, yycolumn); }

// Valores Inteiros Literais
{inteiro}+  { return new Token(TokenType.INT_LITERAL, yytext(), yyline, yycolumn); }

// Valores Reais (De Ponto Flutuante) Literais
{reais}+  { return new Token(TokenType.FLOAT_LITERAL, yytext(), yyline, yycolumn); }

// Comentários
"**" [^\n]* {  }
">>" [^*] ~"<<" { }

. { 
    // Casa com qualquer caracter que não casar com as expressoes anteriores.
    System.out.println("Illegal character : " + yytext());
	System.out.println("Line: " + yyline);
	System.out.println("Column: " + yycolumn);
}

<<EOF>> {
	// Casa com o fim do arquivo apenas.
	return new Token(TokenType.EOF, yyline, yycolumn);
}
