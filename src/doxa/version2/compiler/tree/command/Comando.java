package doxa.version2.compiler.tree.command;

import doxa.version2.compiler.tree.Tipo;

public interface Comando {
	Boolean verificarSemantica();
	String gerarCodigo(String filename);
}
