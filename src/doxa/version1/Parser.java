package doxa.version1;

import java.io.IOException;
import java.io.InputStream;

import doxa.util.CompilerException;
import doxa.version1.TokenType;


/**
 * Esta classe faz (apenas) o reconhecimento sintático (parsing) da linguagem Xpress-0. 
 * 
 * @author Ikaro Alef e Kenedy Felipe
 */
public class Parser {
	private Lexer lexer;
	private Token currentToken;
	
	public Parser() {
	}
	
	/**
	 * Metodo principal, a partir do qual é feito reconhecimento de um código fonte em Xpress-0.
	 */
	public String parse(InputStream input) throws CompilerException {
		String resultado;

		try {
			lexer = new Lexer(input);               // reinicia o lexer
			currentToken = lexer.nextToken(); // lê o primeiro token

			parseProgram();             // tenta reconhecer algo que case com o símbolo "program", que eh o símbolo inicial
			acceptToken(TokenType.EOF); // confirma que chegou ao fim do arquivo
			
			resultado = "Ok";		    // se nao der exceção antes de chegar aqui, então o programa está sintaticamente correto

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
			throw new CompilerException("Token inesperado: "
					        + "foi lido um \"" + currentToken.getType() 
					        + "\", quando o esperado era \"" + tp + "\".");
		}

	}
	
	///////////////////////////////////////////////////////////
	//////////// METODOS PARA OS NÃO-TERMINAIS ////////////////
	
	/**
	 *   <program> ::= <command>
     */
	private void parseProgram() throws CompilerException, IOException {
		parseCommand();
	}
	
	/**
	 *   <command> ::= <expr> ";"
	 */
	private void parseCommand() throws CompilerException, IOException {
		parseExprA();
		acceptToken(TokenType.PT_VIRG);
	}
	
	/**
	 *   <expr> ::= <exprA>
	 
	 */
	
	// <exprA> ::= <exprB> <restoExprA>
	private void parseExprA() throws CompilerException, IOException {
		parseExprB();
		parseRestoExprA();
	}
	/*
	 *	<restoExprA> ::= "+" <exprB> <restoExprA>
	 *				| - vazio -
	 */
	private void parseRestoExprA() throws CompilerException, IOException{
		if (this.currentToken.getType() == TokenType.MAIS){
			acceptToken();
			parseExprB();
			parseRestoExprA();
		}
		else{
			// produção vazia = faz nada
		}
		
	}
	
	// <exprB> ::= <exprBasic> ("*" <exprBasic>)*
	private void parseExprB() throws CompilerException, IOException{
		parseExprBasic();
		while(currentToken.getType() == TokenType.VEZES){
			acceptToken();
			parseExprBasic();
		}
	}

	/**
	 *   <exprBasic> ::= "(" <expr> ")" 
	 *                 | NUM_LITERAL
	 * @throws IOException 
	 */
	private void parseExprBasic() throws CompilerException, IOException {
		if (currentToken.getType() == TokenType.ABRE_PAR) {
			acceptToken();
			parseExprA();
			acceptToken(TokenType.FECHA_PAR);
			
		} else if (currentToken.getType() == TokenType.INT_LITERAL) { //LEMBRAR DE COLOCAR FLOAT E CHAR LITERAL
			acceptToken();
			
		} else {
			throw new CompilerException("Token inesperado: " + currentToken.getType() + ".");
		}
	}

}
