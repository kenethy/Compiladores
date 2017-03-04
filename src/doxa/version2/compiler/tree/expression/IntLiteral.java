package doxa.version2.compiler.tree.expression;

import doxa.version2.compiler.tree.Tipo;

public class IntLiteral implements Expressao {
	private Integer intLiteral;

	public IntLiteral(Integer intLiteral) {
		this.intLiteral = intLiteral;
	}
	
	@Override
	public Boolean verificarSemantica() {
		return null;
	}

	@Override
	public Tipo getTipo() {
		return Tipo.INT;
	}

	@Override
	public String gerarCodigoIntermediario(String filename) {
		return null;
	}
}
