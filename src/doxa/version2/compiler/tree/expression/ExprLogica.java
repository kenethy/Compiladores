package doxa.version2.compiler.tree.expression;

import java.io.PrintStream;

import doxa.version2.compiler.tree.Tipo;

public class ExprLogica implements Expressao {
	private Expressao exp1;
	private Expressao exp2;
	private String operLogico;
	private Tipo tipo;

	public ExprLogica(Expressao e1, Expressao e2, String oper) {
		this.exp1 = e1;
		this.exp2 = e2;
		this.operLogico = oper;
	}

	@Override
	public Boolean verificarSemantica() {
		exp1.verificarSemantica();
		exp2.verificarSemantica();
		if ((exp1.getTipo() == exp2.getTipo()) && (operLogico.equals("or") || operLogico.equals("and"))) {
			this.tipo = Tipo.BOOLEAN;
			return true;
		} else {
			System.out.println("Expressão Lógica incorreta");
			return false;
		}
	}

	@Override
	public Tipo getTipo() {
		return this.tipo;
	}

	@Override
	public String gerarCodigo(PrintStream p) {
		exp1.gerarCodigo(p);
		exp2.gerarCodigo(p);
		switch (operLogico) {
		case "and":
			p.println("\tiand");
			break;
		case "or":
			p.println("\tior");
			break;
		}
		return null;
	}
}
