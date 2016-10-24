package doxa.version2.compiler.tree.command;

import doxa.version2.compiler.tree.Tipo;
import doxa.version2.compiler.tree.expression.Expressao;

public class Atribuicao implements Comando {
	private String identificador;
	private Expressao expressao;

	public Atribuicao(String ident, Expressao expressao) {
		this.identificador = ident;
		this.expressao = expressao;
	}

	@Override
	public Boolean verificarSemantica() {
		return null;
	}

	@Override
	public String gerarCodigoIntermediario(String filename) {
		return null;
	}

}
