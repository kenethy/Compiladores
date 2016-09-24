package doxa.version1;

import java.io.IOException;
import java.io.InputStream;

import doxa.util.CompilerException;
import doxa.version1.TokenType;

/**
 * Esta classe faz (apenas) o reconhecimento sintático (parsing) da linguagem
 * Xpress-0.
 * 
 * @author Ikaro Alef e Kenedy Felipe
 */
public class Parser {
	private Lexer lexer;
	private Token currentToken;

	public Parser() {
	}

	/**
	 * Metodo principal, a partir do qual é feito reconhecimento de um código
	 * fonte em Xpress-0.
	 */
	public String parse(InputStream input) throws CompilerException {
		String resultado;

		try {
			lexer = new Lexer(input); // reinicia o lexer
			currentToken = lexer.nextToken(); // lê o primeiro token

			parseProgram(); // tenta reconhecer algo que case com o símbolo
							// "program", que eh o símbolo inicial
			acceptToken(TokenType.EOF); // confirma que chegou ao fim do arquivo

			resultado = "Ok"; // se nao der exceção antes de chegar aqui, então
								// o programa está sintaticamente correto

		} catch (Exception e) {
			e.printStackTrace();
			resultado = e.getMessage();

		}

		return resultado;
	}

	///////////////////////////////////////////////////////////
	//////////// METODOS PARA MANIPULAR OS TOKENS /////////////

	private void acceptToken() throws CompilerException, IOException {
		currentToken = lexer.nextToken();
	}

	private void acceptToken(TokenType tp) throws CompilerException, IOException {
		if (currentToken.getType() == tp) {
			currentToken = lexer.nextToken();

		} else {
			throw new CompilerException("Token inesperado: " + "foi lido um \"" 
					+ currentToken.getType() + "\", quando o esperado era \"" + tp + "\"" 
					+ ", linha: " + currentToken.getLinha() 
					+ ", coluna: " + currentToken.getColuna() + ".");
		}

	}

	///////////////////////////////////////////////////////////
	//////////// METODOS PARA OS NÃO-TERMINAIS ////////////////

	/**
	 * <program> ::= <command>
	 */
	/*
	 * private void parseProgram() throws CompilerException, IOException {
	 * parseCommand(); }
	 */

	/**
	 * <programa> ::= <decl_global>*
	 * 
	 * @throws CompilerException
	 * @throws IOException
	 */
	private void parseProgram() throws CompilerException, IOException {
		while (this.currentToken.getType() == TokenType.VAR || this.currentToken.getType() == TokenType.PROC) {
			parseDecl_global();
		}
	}

	/**
	 * <decl_global> ::= <decl_variavel> | <decl_funcao>
	 * 
	 * @throws CompilerException
	 * @throws IOException
	 */
	private void parseDecl_global() throws CompilerException, IOException {
		if (this.currentToken.getType() == TokenType.VAR) {
			parseDecl_variavel();
		} else if (this.currentToken.getType() == TokenType.PROC) {
			parseDecl_funcao();
		}
	}

	/**
	 * <decl_variavel> ::= "var" <lista_idents> "-" tipo ";"
	 * 
	 * @throws CompilerException
	 * @throws IOException
	 */
	private void parseDecl_variavel() throws CompilerException, IOException {
		acceptToken();
		parseLista_idents();
		acceptToken(TokenType.MENOS);
		parseTipo();
		acceptToken(TokenType.PT_VIRG);
	}

	/**
	 * <lista_idents> ::= IDENTIFICADOR ("," IDENTIFICADOR)*
	 * 
	 * @throws CompilerException
	 * @throws IOException
	 */
	private void parseLista_idents() throws CompilerException, IOException {
		acceptToken(TokenType.IDENTIFICADOR);
		while (this.currentToken.getType() == TokenType.VIRGULA) {
			acceptToken(TokenType.VIRGULA);
			acceptToken(TokenType.IDENTIFICADOR);
		}
	}

	/**
	 * <tipo> ::= "int" | "char" | "float"
	 * 
	 * @throws CompilerException
	 * @throws IOException
	 */
	private void parseTipo() throws CompilerException, IOException {
		if (this.currentToken.getType() == TokenType.INT)
			acceptToken();
		else if (this.currentToken.getType() == TokenType.CHAR)
			acceptToken();
		else if (this.currentToken.getType() == TokenType.FLOAT)
			acceptToken();
	}

	/**
	 * A seguinte produção gera problemas para nossa técnica: 
	 * decl_funcao = "proc" nome_args "-" tipo bloco | "proc" nome_args bloco
	 * 
	 * Foi corrigida da seguinte forma: <decl_funcao> ::= "proc" <nome_args> <resto_funcao> 
	 * 									<resto_funcao> ::= "-" <tipo> <bloco> | <bloco>
	 * 
	 * @throws CompilerException
	 * @throws IOException
	 */
	private void parseDecl_funcao() throws CompilerException, IOException {
		acceptToken(TokenType.PROC);
		parseNome_args();
		parseResto_funcao();

	}

	/**
	 * <nome_args> ::= ( IDENTIFICADOR "(" <param_formais> ")" )+
	 * 
	 * @throws CompilerException
	 * @throws IOException
	 */
	private void parseNome_args() throws CompilerException, IOException {
		do {
			if (this.currentToken.getType() == TokenType.IDENTIFICADOR) {
				acceptToken();
				acceptToken(TokenType.ABRE_PAR);
				parseParam_formais();
				acceptToken(TokenType.FECHA_PAR);
			}
		} while (this.currentToken.getType() == TokenType.IDENTIFICADOR);
	}
	
	/**
	 * <param_formais> ::= IDENTIFICADOR "-" <tipo> ( "," IDENTIFICADOR "-" <tipo> )*
					 	| PRODUÇÃO VAZIO
	 * @throws CompilerException
	 * @throws IOException
	 */
	private void parseParam_formais() throws CompilerException, IOException {
			if (this.currentToken.getType() == TokenType.IDENTIFICADOR){
				acceptToken();
				acceptToken(TokenType.MENOS);
				parseTipo();
				while (this.currentToken.getType() == TokenType.VIRGULA){
					acceptToken();
					acceptToken(TokenType.IDENTIFICADOR);
					acceptToken(TokenType.MENOS);
					parseTipo();
				}
			}
			else {
				//PRODUÇÃO VAZIA = FAZ NADA
			}
	}

	/**
	 * <resto_funcao> ::= "-" <tipo> <bloco> | <bloco>
	 * 
	 * @throws CompilerException
	 * @throws IOException
	 */
	private void parseResto_funcao() throws CompilerException, IOException {
		if (this.currentToken.getType() == TokenType.MENOS) {
			acceptToken();
			parseTipo();
			parseBloco();
		} else
			parseBloco();
	}
	
	/**
	 * <bloco> ::= "{" <lista_comandos> "}"
	 * @throws CompilerException
	 * @throws IOException
	 */
	private void parseBloco() throws CompilerException, IOException {
		acceptToken(TokenType.ABRE_CHAVES);
		parseLista_comandos();
		acceptToken(TokenType.FECHA_CHAVES);
	}
	
	/** 
	 * <lista_comandos> :== (<comando>)*
	 * @throws CompilerException
	 * @throws IOException
	 */
	private void parseLista_comandos() throws CompilerException, IOException {
		while (this.currentToken.getType() == TokenType.IDENTIFICADOR
			|| this.currentToken.getType() == TokenType.WHILE
			|| this.currentToken.getType() == TokenType.IF
			|| this.currentToken.getType() == TokenType.PRNT
			|| this.currentToken.getType() == TokenType.RETURN)
		{
			parseComando();
		}
	}
	
	/**
	 * <comando> :== <decl_variavel>
					| <atribuicao>
					| <iteracao>
					| <decisao>
					| <escrita>
					| <retorno>
					| <bloco>
					| <chamada_func_cmd>
	 * @throws CompilerException
	 * @throws IOException
	 */
	private void parseComando() throws CompilerException, IOException {
		if (this.currentToken.getType() == TokenType.VAR){ //DECLR_VARIAVEL
			parseDecl_variavel(); //NÃO É NECESSARIO ACEITAR O VAR, POIS O PARSE ACEITA DIRETAMENTE
		}else if (this.currentToken.getType() == TokenType.IDENTIFICADOR) { 
			acceptToken();
			if (this.currentToken.getType() == TokenType.ATRIBUICAO){ // ATRIBUIÇÃO
				parseAtribuicao();
			}else if (this.currentToken.getType() == TokenType.ABRE_PAR){ // CHAMADA_FUNC_CMD, o first é ABRE_PARA, POIS VEM DA PRODUÇÃO CHAMADA_FUNC
				parseChamada_func_cmd();
			}
		}else if (this.currentToken.getType() == TokenType.WHILE){ //ITERAÇÃO
			parseIteracao();
		}else if(this.currentToken.getType() == TokenType.IF){ //DECISAO
			parseDecisao();
		}else if (this.currentToken.getType() == TokenType.PRNT){ //ESCRITA
			parseEscrita();
		}else if (this.currentToken.getType() == TokenType.RETURN){ //RETORNO
			parseRetorno();
		}else if (this.currentToken.getType() == TokenType.ABRE_CHAVES){ //BLOCO
			acceptToken();
			parseBloco();
		}
	}

	/**
	 * <atribuicao> ::= IDENTIFICADOR ":=" <expressao> ";"
	 * @throws CompilerException
	 * @throws IOException
	 */
	private void parseAtribuicao() throws CompilerException, IOException{
		acceptToken(); 
		parseExpressao();
		acceptToken(TokenType.PT_VIRG);
	}
	
	/**
	 * <iteracao> = "while" "(" <expressao> ")" <comando> 
	 * @throws CompilerException
	 * @throws IOException
	 */
	private void parseIteracao() throws CompilerException, IOException{
		acceptToken();
		acceptToken(TokenType.ABRE_PAR);
		parseExpressao();
		acceptToken(TokenType.FECHA_PAR);
		parseComando();
	}
	
	/**
	 * decisao =  "if" "(" <expressao> ")" <comando> "else" <comando>
 				| "if" "(" <expressao> ")" <comando>
	 * @throws CompilerException
	 * @throws IOException
	 */
	private void parseDecisao() throws CompilerException, IOException{
		acceptToken();
		acceptToken(TokenType.ABRE_PAR);
		parseExpressao();
		acceptToken(TokenType.FECHA_PAR);
		parseComando();
		parseRestoDecisao();
	}
	
	/**
	 * <restoDecisao> ::= "else" <comando>
	 * 					|  PRODUÇÃO VAZIA
	 * @throws CompilerException
	 * @throws IOException
	 */
	private void parseRestoDecisao() throws CompilerException, IOException{
		if (this.currentToken.getType() == TokenType.ELSE){
			acceptToken();
			parseComando();
		}else{
			//PRODUÇÃO VAZIA = FAZ NADA
			
		}
	}
	
	/**
	 * escrita = "prnt" "(" lista_exprs ")" ";" 
	 * @throws CompilerException
	 * @throws IOException
	 */
	private void parseEscrita() throws CompilerException, IOException{
		acceptToken();
		acceptToken(TokenType.ABRE_PAR);
		parseLista_exprs();
		acceptToken(TokenType.FECHA_PAR);
		acceptToken(TokenType.PT_VIRG);
	}
	
	/**
	 * <retorno> = "return" <expressao> ";" 
	 * @throws CompilerException
	 * @throws IOException
	 */
	private void parseRetorno() throws CompilerException, IOException{
		acceptToken();
		parseExpressao();
		acceptToken(TokenType.PT_VIRG);
	}
	
	/**
	 * <chamada_func_cmd> ::= <chamada_func> ";"
	 * @throws CompilerException
	 * @throws IOException
	 */
	private void parseChamada_func_cmd () throws CompilerException, IOException{
		acceptToken(); //aceita o Token ABRE_PAR
		parseChamada_func();
		acceptToken(TokenType.PT_VIRG);
	}
	
	/**
	 * <chamada_func> ::= ( IDENTIFICADOR "(" <lista_exprs> ")" )+
	 * @throws CompilerException
	 * @throws IOException
	 */
	private void parseChamada_func () throws CompilerException, IOException{ //Atualizar função
		parseLista_exprs();
		acceptToken(TokenType.FECHA_PAR);
	}
	
	/**
	 * <expressao> = <expressao> "+" <expressao>
				   | <expressao> "-" <expressao>
				   | <expressao> "*" <expressao>
				   | <expressao> "/" <expressao>
				   | <expressao> "%" <expressao>
				   | <expressao> "and" <expressao>
				   | <expressao> "or" <expressao>
				   | <expressao> "=" <expressao>
				   | <expressao> "<>" <expressao>
				   | <expressao> "<=" <expressao>
				   | <expressao> "<" <expressao>
				   | <expressao> ">=" <expressao>
				   | <expressao> ">" <expressao>
				   | <expr_basica>
	 * @throws CompilerException
	 * @throws IOException
	 */
	private void parseExpressao() throws CompilerException, IOException{

	}
	
	/**
	 * lista_exprs =  PRODUÇÃO VAZIA
 					| expressao ("," expressao)*
	 * @throws CompilerException
	 * @throws IOException
	 */
	private void parseLista_exprs() throws CompilerException, IOException{
		
	}

	/**
	 * <expr_basica> = "(" <expressao> ")"
 					| "not" <expr_basica>
					| "-" <expr_basica>
					| INT_LITERAL
					| CHAR_LITERAL
					| FLOAT_LITERAL
					| IDENTIFICADOR
					| <chamada_func>
	 * @throws CompilerException
	 * @throws IOException
	 */
	
	///////////////////////////////////////////////////////////
	////////////////////// EXEMPLOS ///////////////////////////
	
	/**
	 * <command> ::= <expr> ";"
	 */
	private void parseCommand() throws CompilerException, IOException {
		parseExprA();
		acceptToken(TokenType.PT_VIRG);
	}

	/**
	 * <expr> ::= <exprA>
	 * 
	 */

	// <exprA> ::= <exprB> <restoExprA>
	private void parseExprA() throws CompilerException, IOException {
		parseExprB();
		parseRestoExprA();
	}

	/*
	 * <restoExprA> ::= "+" <exprB> <restoExprA> | - vazio -
	 */
	private void parseRestoExprA() throws CompilerException, IOException {
		if (this.currentToken.getType() == TokenType.MAIS) {
			acceptToken();
			parseExprB();
			parseRestoExprA();
		} else {
			// produção vazia = faz nada
		}

	}

	// <exprB> ::= <exprBasic> ("*" <exprBasic>)*
	private void parseExprB() throws CompilerException, IOException {
		parseExprBasic();
		while (currentToken.getType() == TokenType.VEZES) {
			acceptToken();
			parseExprBasic();
		}
	}

	/**
	 * <exprBasic> ::= "(" <expr> ")" | NUM_LITERAL
	 * 
	 * @throws IOException
	 */
	private void parseExprBasic() throws CompilerException, IOException {
		if (currentToken.getType() == TokenType.ABRE_PAR) {
			acceptToken();
			parseExprA();
			acceptToken(TokenType.FECHA_PAR);

		} else if (currentToken.getType() == TokenType.INT_LITERAL) { // LEMBRAR
																		// DE
																		// COLOCAR
																		// FLOAT
																		// E
																		// CHAR
																		// LITERAL
			acceptToken();

		} else {
			throw new CompilerException("Token inesperado: " + currentToken.getType() + ".");
		}
	}

}
