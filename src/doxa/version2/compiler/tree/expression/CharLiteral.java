package doxa.version2.compiler.tree.expression;

import doxa.version2.compiler.tree.Tipo;

public class CharLiteral implements Expressao {
	private String charLiteral;

	public CharLiteral(String charLiteral) {
		this.charLiteral = charLiteral;
	}

	public Tipo getTipo() {
		return null;
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
