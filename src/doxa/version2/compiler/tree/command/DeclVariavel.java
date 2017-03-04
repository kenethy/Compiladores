package doxa.version2.compiler.tree.command;

import java.util.LinkedList;

import doxa.version2.compiler.tree.DeclGlobal;
import doxa.version2.compiler.tree.Tipo;
import symbolTable.SymbolTable;

public class DeclVariavel implements Comando, DeclGlobal {
	private LinkedList<String> idents;
	private Tipo tipo;

	public DeclVariavel() {
		this.idents = new LinkedList<String>();
	}

	public DeclVariavel(LinkedList<String> ids, Tipo tipo) {
		this.idents = ids;
		this.tipo = tipo;
	}

	public DeclVariavel(String id, Tipo tipo) {
		this.idents = new LinkedList<String>();
		idents.addLast(id);
		this.tipo = tipo;
	}

	public Tipo getTipo() {
		return this.tipo;
	}

	public LinkedList<String> getIdents() {
		return idents;
	}

	@Override
	public Boolean verificarSemantica() {
		for (int i = 0; i < idents.size(); i++) {
			if (SymbolTable.getInstance().nameExistsLocal(idents.get(i))) {
				System.out.println("Variável duplicada.");
				return false;
			} else { // se nao, adicione à tabela
				SymbolTable.getInstance().putLocal(idents.get(i), tipo);
			}
		}

		return true;
	}

	@Override
	public String gerarCodigoIntermediario(String filename) {
		return null;
	}

}
