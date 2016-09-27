package doxa.version1.tests;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

import doxa.version1.Parser;

public class TestParser {

	/**
	 * Este metodo executa um pequeno teste de reconhecimento.  
	 */
	public static void main(String[] args) throws Exception {
		Parser parser = new Parser();
		InputStream entrada;

		System.out.println(" == TESTE DO PARSER ==\n");
		
		//TESTA O PARSER USANDO UMA STRING:		
		Scanner sc = new Scanner(System.in);
		
		//while(true){
		//String codigo = "proc main(){var n, nRebuilt - int;			n := 51423; ** numero a ser testado			>> A divisao de inteiros arredonda para baixo (em caso			de divisao inexata). Assim, numeros impares ficarao			com uma unidade a menos do que seu valor inicial. <<			nRebuilt := (n / 2) * 2;			if (n = nRebuilt)			prnt('P', 'A', 'R');			else			prnt('I', 'M', 'P', 'A', 'R');			}";
		//String codigo = sc.nextLine();
		/*	String codigo = new String("proc main()"
					+ " {"
					+ "var n, nRebuilt - int;"
					+ "n := 51423; ** numero a ser testado \n"
					+ ">> A divisao de inteiros arredonda para baixo (em caso"
					+ "de divisao inexata). Assim, numeros impares ficarao"
					+ "com uma unidade a menos do que seu valor inicial. <<"
					+ "nRebuilt := (n / 2) * 2;"
					+ "if (n = nRebuilt)"
					+ "prnt('P', 'A', 'R');"
					+ "else"
					+ "prnt('I', 'M', 'P', 'A', 'R');"
					+ "}");
			*/
		//System.out.println(" Texto fonte a ser reconhecido: \"" + codigo + "\"");		
		
		//entrada = new ByteArrayInputStream(codigo.getBytes());

		//PARA TESTAR USANDO ARQUIVO:
		entrada = new FileInputStream("entrada");
		
		String msg = parser.parse(entrada);
		System.out.println(" >>" + msg + "\n");
		
		System.out.println(" == FIM ==");
		//}
	}
	
}
