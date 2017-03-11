package doxa.version2.compiler.tree.expression;

import java.io.PrintStream;

import doxa.version2.compiler.tree.Tipo;

public class CharLiteral implements Expressao {
	private String charLiteral;

	public CharLiteral(String charLiteral) {
		this.charLiteral = charLiteral;
	}

	public Tipo getTipo() {
		return Tipo.CHAR;
	}

	@Override
	public Boolean verificarSemantica() {
		return true;
	}

	@Override
	public String gerarCodigo(PrintStream p) {
		p.printf("\tldc %s\n",charLiteral);
		return null;
	}
}
