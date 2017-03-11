package doxa.version2.compiler.tree.command;

import java.io.PrintStream;
import java.util.List;

import doxa.version2.compiler.tree.expression.Expressao;

public class Escrita implements Comando {
	private List<Expressao> listaExpressoes;

	public Escrita(List<Expressao> listExpr) {
		this.listaExpressoes = listExpr;
	}

	@Override
	public Boolean verificarSemantica() {
		for (int i=0; i<listaExpressoes.size(); i++){
			if(!listaExpressoes.get(i).verificarSemantica())
				return false;
		}
		return true;
	}

	@Override
	public String gerarCodigo(PrintStream p) {
		return null;
	}
}
