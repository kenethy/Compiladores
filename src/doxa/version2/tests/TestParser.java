package doxa.version2.tests;

import java.io.FileInputStream;
import java.io.IOException;

import doxa.version2.compiler.syntax.Lexer;
import doxa.version2.compiler.syntax.Parser;
import doxa.version2.compiler.tree.Programa;
import java_cup.runtime.Symbol;


/**
 * Classe de teste para os parsers dos projetos. 
 *
 * Pablo Azevedo Sampaio
 * 05/10/2015
 */

public class TestParser {

	public static void main(String args[]) throws IOException {
		Lexer lexer;   
		Parser parser;
		
       // BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// String arquivo;
		/*
		if (args.length == 0) {
			System.out.print("Digite o nome do arquivo: ");
			arquivo = in.readLine();
		} else {
			arquivo = args[0];
		}		
		*/
		try {
			lexer = new Lexer(new FileInputStream("entrada"));
			parser = new Parser(lexer);

			Symbol output = parser.parse();
			
			Programa p = (Programa) output.value;
			if (p.verificarSemantica()){
				System.out.println("Semantica OK");
				p.gerarCodigo("Codigo.j");

				//pra rodar o jasmin, compilar o .J e executar o .class com o Java
				Runtime.getRuntime().exec("cmd /c start jasmin.bat"); 
			}
			
			System.out.println("Saida: " + p);
		
		} catch (Exception e) {
			System.out.println("Erro");
			e.printStackTrace();
		}
	}
}
