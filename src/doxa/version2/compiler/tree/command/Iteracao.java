package doxa.version2.compiler.tree.command;

import java.io.PrintStream;

import doxa.version2.compiler.tree.Tipo;
import doxa.version2.compiler.tree.expression.Expressao;

public class Iteracao implements Comando {

	private Expressao expressao;
	private Comando comando;

	public Iteracao(Expressao expressao, Comando comando) {
		this.expressao = expressao;
		this.comando = comando;
	}

	@Override
	public Boolean verificarSemantica() {
		if (!expressao.verificarSemantica())
			return false;
		if (!comando.verificarSemantica())
			return false;
		return true;
	}

	@Override
	public String gerarCodigo(PrintStream p) {
		return null;
	}
	
	public Boolean hasReturn() {
		return comando.hasReturn();
	}

}
