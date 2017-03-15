package doxa.version2.compiler.tree.command;

import java.io.PrintStream;

public interface Comando {
	Boolean verificarSemantica();
	String gerarCodigo(PrintStream p);
	Boolean hasReturn(); //contornar problema do Jasmin com o nosso pularElse de Decisão (pois se houvesse um return no IF e o pular else depois sem comandos no Jasmin, dava erro
}
