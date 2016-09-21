package doxa.version1;


/**
 * Esta enumeração guarda os tipos de token
 * que a linguagem suporta.
 */
public enum TokenType {
	//	Identificador [a-z]([a-zA-Z_]|[0-9])*
	IDENTIFICADOR,
	//	Operadores relacionais:
	//	< | > | <= | >= | = | <>
	MENOR_QUE,
	MAIOR_QUE,
	MENOR_IGUAL,
	MAIOR_IGUAL,
	IGUAL,
	DIFERENTE,
	//	Operadores lógico-aritméticos (alguns são palavras reservadas também):
	//	+ | - | * | / | % | and | or | not
	MAIS,
	MENOS,
	VEZES,
	DIVISAO,
	MODULO,
	AND,
	OR,
	NOT,
	//	Operador de atribuição:
	//	:=
	ATRIBUICAO,
	//	Símbolos especiais:
	//	) | ( | , | ; | { | }
	FECHA_PAR,
	ABRE_PAR,
	VIRGULA,
	PT_VIRG,
	ABRE_CHAVES,
	FECHA_CHAVES,
	//Palavras-chave reservadas:
	//if | else | while | return | float | char | void | prnt | int | and | or | not | proc | var
	IF,
	ELSE,
	WHILE,
	RETURN,
	FLOAT,
	CHAR,
	VOID,
	PRNT,
	INT,
	PROC,
	VAR,
	//	Valores inteiros literais:
	//	[0-9]+
	INT_LITERAL,
	//	Valores reais (de ponto flutuante) literais:
	//	[0-9]*.[0-9]+ | [0-9]+.[0-9]*
	FLOAT_LITERAL,
	//	Valores caracteres literais:
	//	'([0-9]|[a-zA-Z]|\n|\t| |:|(|)|,)'
	CHAR_LITERAL,
	//	Comentários
	COMENTARIO,
	//Fim de Arquivo
	EOF
}
