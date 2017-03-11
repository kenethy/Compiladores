package doxa.version2.compiler.tree.command;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import doxa.version2.compiler.tree.Tipo;

public interface Comando {
	Boolean verificarSemantica();
	String gerarCodigo(PrintStream p);
}
