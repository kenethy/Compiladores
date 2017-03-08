package doxa.version2.compiler.tree.expression;

import doxa.version2.compiler.tree.Tipo;

public class ExprAritmetica implements Expressao {

	private Expressao exp1;
	private Expressao exp2;
	private String operacao;
	private Tipo tipo = null;

	public ExprAritmetica(Expressao exp1, Expressao exp2, String operacao) {
		this.exp1 = exp1;
		this.exp2 = exp2;
		this.operacao = operacao;
	}

	@Override
	public Boolean verificarSemantica() {
		if (!exp1.verificarSemantica())
			return false;
		if (!exp2.verificarSemantica())
			return false;
		// regra 1
		if (exp1.getTipo() == exp2.getTipo()) {
			if (exp1.getTipo() == Tipo.FLOAT)
				this.tipo = Tipo.FLOAT;
			else if (exp1.getTipo() == Tipo.INT) {
				this.tipo = Tipo.INT;
			} else {
				System.out.println("Tipos incompatíveis");
				return false;
			}
		}

		// regra 2
		else if (exp1.getTipo() == Tipo.FLOAT && exp2.getTipo() == Tipo.INT) {
			this.tipo = Tipo.FLOAT;
		}

		// regra 3
		else if (exp1.getTipo() == Tipo.INT && exp2.getTipo() == Tipo.INT) {
			if (operacao.equals("%"))
				this.tipo = Tipo.INT;
		}

		// regra 4
		else if (exp1.getTipo() == Tipo.CHAR && exp2.getTipo() == Tipo.INT) {
			if (operacao.equals("+") || operacao.equals("-"))
				this.tipo = Tipo.CHAR;
		}

		// regra 6
		else {
			System.out.println("Tipos incompatíveis na expressão");
			return false;
		}

		return true;
	}

	@Override
	public Tipo getTipo() {
		return this.tipo;
	}

	@Override
	public String gerarCodigo(String filename) {
		return null;
	}

}
