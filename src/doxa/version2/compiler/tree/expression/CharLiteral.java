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
		// converter o char para o equivalente no ASCII
		int c = (int) charLiteral.charAt(1);

		// caso especial para pular linha
		if (charLiteral.equals("'\\n'")) {
			p.print("\tldc 10\n");

			// caso especial para tabulação
		} else if ((charLiteral.equals("'\\t'"))) {
			p.print("\tldc 09\n");

		} else
			p.printf("\tldc %d\n", c);
		return null;
	}
}
