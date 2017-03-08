package doxa.version2.compiler.tree.expression;

import doxa.version2.compiler.tree.Tipo;

public class FloatLiteral implements Expressao {
	private Float floatLiteral;

	public FloatLiteral(Float floatLiteral) {
		this.floatLiteral = floatLiteral;
	}

	
	@Override
	public Boolean verificarSemantica() {
		return true;
	}

	@Override
	public Tipo getTipo() {
		return Tipo.FLOAT;
	}


	@Override
	public String gerarCodigo(String filename) {
		return null;
	}
}
