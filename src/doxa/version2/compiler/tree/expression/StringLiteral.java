package doxa.version2.compiler.tree.expression;

import doxa.version2.compiler.tree.Tipo;

public class StringLiteral implements Expressao {

	private String stringLiteral;

	public StringLiteral(String stringLiteral) {
		this.stringLiteral = stringLiteral;

	}

	@Override
	public Boolean verificarSemantica() {
		return null;
	}

	@Override
	public Tipo getTipo() {
		return null;
	}


	@Override
	public String gerarCodigoIntermediario(String filename) {
		return null;
	}
}