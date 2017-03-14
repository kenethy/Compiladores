package doxa.version2.compiler.tree.expression;

import java.io.PrintStream;

import doxa.version2.compiler.tree.Tipo;

public class ExpUnaria implements Expressao {
	private Expressao expr;
	private String operacao;
	private Tipo tipo;
	private static int labelCount;

	public ExpUnaria(String operacao, Expressao expr) {
		this.operacao = operacao;
		this.expr = expr;
	}

	public void nextLabelCount() {
		labelCount++;
	}

	public int getLabelCount() {
		int r = labelCount;
		return r;
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

	public String gerarCodigo(PrintStream p) {
		expr.gerarCodigo(p);
		switch (operacao) {
		case "-":
			if (tipo == Tipo.FLOAT) {
				p.println("\tfneg");
			} else if (tipo == Tipo.INT) {
				p.println("\tineg");
			}
			break;
		case "not":
			if (tipo == Tipo.BOOLEAN) {
				p.println("\tifeq pTrue" + getLabelCount());
				p.println("\ticonst_0");
				p.println("\tgoto jumpPTrue" + getLabelCount());
				p.println("pTrue" + getLabelCount() + ":\n\ticonst_1");
				p.println("jumpPTrue" + getLabelCount() + ":");
			}
			break;
		}
		nextLabelCount();
		return null;
	}
}