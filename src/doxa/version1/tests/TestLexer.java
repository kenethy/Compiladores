package doxa.version1.tests;

import java.io.FileInputStream;

import doxa.version1.Lexer;
import doxa.version1.Token;
import doxa.version1.sym;
import java_cup.runtime.Symbol;

public class TestLexer {

	/**
	 * Este metodo permite fazer testes com o lexer usando a
	 * entrada padrão.  
	 */
	public static void main(String[] args) throws Exception {
		Lexer lexer = new Lexer(System.in);
		Token token = null;
		
		System.out.println("\n\n\n");
		System.out.println(" == TESTE DO LEXER ==\n");
		System.out.println(" Digite alguma string terminada em \";\" e tecle ENTER:\n\n");
		System.out.print(" ");

		// passa a entrada padrão para o lexer
		//lexer.yyreset(System.in);
		
		// parar passar um arquivo como entrada
		//lexer.reset(new FileInputStream("caminho do arquivo"));
		
		do {
			token = lexer.yylex();
			System.out.println("\t" + token);
		
		} while (!token.equals(sym.PT_VIRG));
		
		System.out.println("\n == FIM ==");
		
	}
	
}
