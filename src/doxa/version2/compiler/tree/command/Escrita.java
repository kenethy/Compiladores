package doxa.version2.compiler.tree.command;

import java.util.List;

import doxa.version2.compiler.tree.expression.Expressao;

public class Escrita implements Comando {
	private List<Expressao> listaExpressoes;

	public Escrita(List<Expressao> listExpr) {
		this.listaExpressoes = listExpr;
	}

	@Override
	public Boolean verificarSemantica() {
		return null;
	}

	@Override
	public String gerarCodigoIntermediario(String filename) {
		return null;
	}
}
