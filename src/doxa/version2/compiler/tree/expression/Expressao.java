package doxa.version2.compiler.tree.expression;

import java.io.PrintStream;

import doxa.version2.compiler.tree.Tipo;

public interface Expressao {
	Boolean verificarSemantica();
	Tipo getTipo();
	String gerarCodigo(PrintStream p);
}
