package doxa.version2.tests;

import java.io.FileInputStream;

import doxa.version2.compiler.syntax.Lexer;
import doxa.version2.compiler.syntax.sym;
import java_cup.runtime.Symbol;

/**
 * Classe criada para fazer testes com o lexer.
 */
public class TestLexer {

	public static void main(String[] args) throws Exception {
		Lexer lexer = null;
		Symbol token = null;

		System.out.println("\n\n\n");
		System.out.println(" == TESTE DO LEXER ==\n");
		// System.out.println(" Digite alguma string terminada em \";\" e tecle
		// ENTER:\n\n");
		System.out.print(" ");

		// passa a entrada padrão (primeira linha) ou um arquivo (segunda linha)
		// para o lexer
		// lexer = new Lexer(System.in);
		lexer = new Lexer(new FileInputStream("exemplo1"));

		do {
			token = lexer.next_token();
			System.out.println("\t" + printToken(token));

		} while (token.sym != sym.EOF);

		System.out.println("\n == FIM ==");
	}

	public static String printToken(Symbol token) {
		if (token.value == null) {
			return "[tipo_" + token.sym + ", " + token.left + ":" + token.right + "]";
		} else {
			return "[tipo_" + token.sym + "," + token.value + ", " + token.left + ":" + token.right + "]";
		}

	}

}