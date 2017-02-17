package doxa.version2.compiler.tree;

import java.util.LinkedList;

public class Programa {
	private LinkedList<DeclGlobal> declaracoes;

	public Programa() {
		declaracoes = new LinkedList<DeclGlobal>();
	}

	public void addLast(DeclGlobal dec) {
		this.declaracoes.addLast(dec);
	}
	
	public Boolean verificarSemantica() {
		Boolean r = true;
		for (int i =0; i < declaracoes.size(); i++ ){
			r = declaracoes.get(i).verificarSemantica();
			if (r == false)
				break;
		}
		return r;
	}
	
	public String gerarCodigoIntermediario(String filename) {
		return null;
	}
}