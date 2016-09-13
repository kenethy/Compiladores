package doxa.version1;

/* 	Projeto Versão 1 - Compiladores
	
		Alunos
	---------------
	Ikaro Alef
	Kenedy Felipe
*/

%%

%class Lexer
%public
%type Token
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

{caracter}+ { return new Token(TokenType.CHAR_LITERAL, yytext()); }

// Operadores Relacionais
"<" { return new Token(TokenType.MENOR_QUE); }
">" { return new Token(TokenType.MAIOR_QUE); }
"<=" { return new Token(TokenType.MENOR_IGUAL); }
">=" { return new Token(TokenType.MAIOR_IGUAL); }
"=" { return new Token(TokenType.IGUAL); }
"<>" { return new Token(TokenType.DIFERENTE); }

// Operadores Logico-Aritmeticos
"+" { return new Token(TokenType.MAIS); }
"-" { return new Token(TokenType.MENOS); }
"*" { return new Token(TokenType.VEZES); }
"/" { return new Token(TokenType.DIVISAO); }
"%" { return new Token(TokenType.MODULO); }
and { return new Token(TokenType.AND); }
or { return new Token(TokenType.OR); }
not { return new Token(TokenType.NOT); }

// Operador de Atribuição
":=" { return new Token(TokenType.ATRIBUICAO); }

// Simbolos Especiais
")" { return new Token(TokenType.FECHA_PAR); }
"(" { return new Token(TokenType.ABRE_PAR); }
"," { return new Token(TokenType.VIRGULA); }
";" { return new Token(TokenType.PT_VIRG); }
"{" { return new Token(TokenType.ABRE_CHAVES); }
"}" { return new Token(TokenType.FECHA_CHAVES); }

// Palavras-chave Reservadas
if { return new Token(TokenType.IF); }
else { return new Token(TokenType.ELSE); }
while { return new Token(TokenType.WHILE); }
return { return new Token(TokenType.RETURN); }
float { return new Token(TokenType.FLOAT); }
char { return new Token(TokenType.CHAR); }
void { return new Token(TokenType.VOID); }
prnt { return new Token(TokenType.PRNT); }
int { return new Token(TokenType.INT); }
proc { return new Token(TokenType.PROC); }
var { return new Token(TokenType.VAR); }

// Identificador
{identificador}+   { return new Token(TokenType.IDENTIFICADOR, yytext()); }

// Valores Inteiros Literais
{inteiro}+  { return new Token(TokenType.INT_LITERAL, yytext()); }

// Valores Reais (De Ponto Flutuante) Literais
{reais}+  { return new Token(TokenType.FLOAT_LITERAL, yytext()); }

// Comentários
"**" [^\n]* { return new Token(TokenType.COMENTARIO); }
">>" [^*] ~"<<" { return new Token(TokenType.COMENTARIO); }

. { 
    // Casa com qualquer caracter que não casar com as expressoes anteriores.
    System.out.println("Illegal character : " + yytext());
	System.out.println("Line: " + yyline);
	System.out.println("Column: " + yycolumn);
}

<<EOF>> {
	// Casa com o fim do arquivo apenas.
	return new Token(TokenType.EOF);
}
