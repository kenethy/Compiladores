package doxa.version2.compiler.tree.command;

import java.io.PrintStream;

import doxa.version2.compiler.tree.Tipo;
import doxa.version2.compiler.tree.expression.Expressao;

public class Decisao implements Comando {
	private Expressao expressao;
	private Comando comandoIf;
	private Comando comandoElse;
	private static int labelCount = 0;

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
		return labelCount;
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
		int r = 0;
		nextLabelCount();
		expressao.gerarCodigo(p);
		p.println("comandoIf" + getLabelCount() + ":");
		// se for 0 que est� no topo da pilha (vindo da execu��o da expr) quer
		// dizer que a verifica��o deu falso, ent�o pula pro else
		if(comandoElse != null)
			p.println("\tifeq comandoElse" + getLabelCount());
		else{
			r = getLabelCount();
			p.println("\tifeq pularIf" + getLabelCount());
		}
		comandoIf.gerarCodigo(p);
		if (!comandoIf.hasReturn())
			p.println("\tgoto pularElse" + getLabelCount());
		p.println("comandoElse" + getLabelCount() + ":");
		if (comandoElse != null) {
			comandoElse.gerarCodigo(p);
		}else p.println("pularIf" + r + ":");
		if (!comandoIf.hasReturn())
			p.println("pularElse" + getLabelCount() + ":");
		nextLabelCount();
		return null;
	}

	public Boolean hasReturn() {
		return comandoIf.hasReturn();
	}

}
