package doxa.version1;


/**
 * Esta enumeração guarda os tipos de token
 * que a linguagem suporta.
 */
public enum TokenType {
	IDENTIFICADOR,
	MENOR_QUE, MAIOR_QUE, MENOR_IGUAL, MAIOR_IGUAL, IGUAL, DIFERENTE,
	MAIS, MENOS, VEZES, DIVISAO, MODULO, AND, OR, NOT, 
	ATRIBUICAO,
	FECHA_PAR, ABRE_PAR, VIRGULA, PT_VIRG, ABRE_CHAVES, FECHA_CHAVES,
	IF, ELSE, WHILE, RETURN, FLOAT, CHAR, VOID, PRNT, INT, PROC, VAR,
	INT_LITERAL,
	FLOAT_LITERAL,
	CHAR_LITERAL,	
	EOF
}
