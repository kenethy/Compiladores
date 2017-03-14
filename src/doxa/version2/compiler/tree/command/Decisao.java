package doxa.version2.compiler.tree.command;

import java.io.PrintStream;

import doxa.version2.compiler.tree.Tipo;
import doxa.version2.compiler.tree.expression.Expressao;

public class Decisao implements Comando {
	private Expressao expressao;
	private Comando comandoIf;
	private Comando comandoElse;
	private static int labelCount;

	/**
	 * Construtor para if-else completo.
	 */
	public Decisao(Expressao expr, Comando cmdIf, Comando cmdElse) {
		this.expressao = expr;
		this.comandoIf = cmdIf;
		this.comandoElse = cmdElse;
	}

	/**
	 * Construtor para if sem else.
	 */
	public Decisao(Expressao expr, Comando cmdIf) {
		this.expressao = expr;
		this.comandoIf = cmdIf;
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
		this.expressao.verificarSemantica();
		Boolean r = false;
		if (this.expressao.getTipo() == Tipo.BOOLEAN) {
			if (this.comandoIf.verificarSemantica() == true)
				r = true;
		}
		if (comandoElse == null) {
			return r;
		}
		if (comandoElse != null && r == true) {
			if (this.comandoElse.verificarSemantica() == true) {
				return true;
			} else {
				System.out.println("Semantica do ELSE incorreta");
				return false;
			}
		}
		System.out.println("Semantica de IF incorreta");
		return false;
	}

	@Override
	public String gerarCodigo(PrintStream p) {
		expressao.gerarCodigo(p);
		p.println("comandoIf" + getLabelCount() + ":");
		// se for 0 que está no topo da pilha (vindo da execução da expr) quer
		// dizer que a verificação deu falso, então pula pro else
		p.println("\tifeq comandoElse" + getLabelCount());
		comandoIf.gerarCodigo(p);
		p.println("\tgoto pularElse" + getLabelCount());
		p.println("comandoElse" + getLabelCount() + ":");
		if (comandoElse != null) {
			comandoElse.gerarCodigo(p);
		}
		p.println("pularElse" + getLabelCount() + ":");
		nextLabelCount();
		return null;
	}

}
