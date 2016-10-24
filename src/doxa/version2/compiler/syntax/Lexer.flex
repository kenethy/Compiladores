package doxa.version2.compiler.syntax;

/**		Projeto Compiladores Linguagem Doxa
  *		@author Ikaro Alef e Kenedy Felipe
  */
import java_cup.runtime.Symbol;

%%

%class Lexer
%public
%cup
%line
%column

whiteSpace=([ \n\t\f\r]+)
identificador=[a-z]([a-zA-Z_]|[0-9])*
inteiro=[0-9]+
reais=[0-9]*"."[0-9]+
caracter = ('[0-9]'|'[a-zA-Z]'|'\\n'|'\\t'|' '|'\ '|':'|'\('|'\)'|',')

%%

// Caracteres Brancos
{whiteSpace} { 
	// Caracteres ignorados.
	// Nenhum Symbol é retornado.
}

{caracter}+ { return new Symbol(sym.CHAR_LITERAL, yyline, yycolumn, yytext()); }

// Operadores Relacionais
"<" { return new Symbol(sym.MENOR_QUE, yyline, yycolumn); }
">" { return new Symbol(sym.MAIOR_QUE, yyline, yycolumn); }
"<=" { return new Symbol(sym.MENOR_OU_IGUAL, yyline, yycolumn); }
">=" { return new Symbol(sym.MAIOR_OU_IGUAL, yyline, yycolumn); }
"=" { return new Symbol(sym.IGUAL_QUE, yyline, yycolumn); }
"<>" { return new Symbol(sym.DIFERENTE_QUE, yyline, yycolumn); }

// Operadores Logico-Aritmeticos
"+" { return new Symbol(sym.SOMA, yyline, yycolumn); }
"-" { return new Symbol(sym.SUB, yyline, yycolumn); }
"*" { return new Symbol(sym.MULT, yyline, yycolumn); }
"/" { return new Symbol(sym.DIV, yyline, yycolumn); }
"%" { return new Symbol(sym.RESTO, yyline, yycolumn); }
and { return new Symbol(sym.AND, yyline, yycolumn); }
or { return new Symbol(sym.OR, yyline, yycolumn); }
not { return new Symbol(sym.NOT, yyline, yycolumn); }

// Operador de Atribuição
":=" { return new Symbol(sym.ATRIBUICAO, yyline, yycolumn); }

// Simbolos Especiais
")" { return new Symbol(sym.FECHA_PAR, yyline, yycolumn); }
"(" { return new Symbol(sym.ABRE_PAR, yyline, yycolumn); }
"," { return new Symbol(sym.VIRGULA, yyline, yycolumn); }
";" { return new Symbol(sym.PONTO_VIRGULA, yyline, yycolumn); }
"{" { return new Symbol(sym.ABRE_CHAVE, yyline, yycolumn); }
"}" { return new Symbol(sym.FECHA_CHAVE, yyline, yycolumn); }

// Palavras-chave Reservadas
if { return new Symbol(sym.KEY_IF, yyline, yycolumn); }
else { return new Symbol(sym.KEY_ELSE, yyline, yycolumn); }
while { return new Symbol(sym.KEY_WHILE, yyline, yycolumn); }
return { return new Symbol(sym.KEY_RETURN, yyline, yycolumn); }
float { return new Symbol(sym.KEY_FLOAT, yyline, yycolumn); }
char { return new Symbol(sym.KEY_CHAR, yyline, yycolumn); }
//void { return new Symbol(sym.KEY_VOID, yyline, yycolumn); }
prnt { return new Symbol(sym.KEY_PRINT, yyline, yycolumn); }
int { return new Symbol(sym.KEY_INT, yyline, yycolumn); }
proc { return new Symbol(sym.KEY_PROC, yyline, yycolumn); }
var { return new Symbol(sym.KEY_VAR, yyline, yycolumn); }

// Identificador
{identificador}+   { return new Symbol(sym.IDENTIFICADOR, yyline, yycolumn, yytext()); }

// Valores Inteiros Literais
{inteiro}+  { return new Symbol(sym.INT_LITERAL, yyline, yycolumn, yytext()); }

// Valores Reais (De Ponto Flutuante) Literais
{reais}+  { return new Symbol(sym.FLOAT_LITERAL, yyline, yycolumn, yytext()); }

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
	return new Symbol(sym.EOF, yyline, yycolumn);
}
