package doxa.version2.compiler.tree.command;

import java.io.PrintStream;

public interface Comando {
	Boolean verificarSemantica();
	String gerarCodigo(PrintStream p);
}
