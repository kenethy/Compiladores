package doxa.version2.compiler.tree.expression;

import doxa.version2.compiler.tree.Tipo;

public class ExpUnaria implements Expressao {
	private Expressao expr;
	private String operacao;
	private Tipo tipo;

	public ExpUnaria(String operacao, Expressao expr) {
		this.operacao = operacao;
		this.expr = expr;
	}

	@Override
	public Boolean verificarSemantica() {
		this.expr.verificarSemantica();
		// regra 5
		if (expr.getTipo() == Tipo.INT && operacao.equals("-"))
			this.tipo = Tipo.INT;
		else if (expr.getTipo() == Tipo.FLOAT && operacao.equals("-"))
			this.tipo = Tipo.FLOAT;

		// regra 9
		else if (expr.getTipo() == Tipo.BOOLEAN && operacao.equals("not"))
			this.tipo = Tipo.BOOLEAN;
		else {
			System.out.println("Expressao Unária incorreta");
			return false;
		}
		return true;
	}

	@Override
	public Tipo getTipo() {
		return this.tipo;
	}

	public String gerarCodigoIntermediario(String filename) {
		return null;
	}
}