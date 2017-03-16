package doxa.version2.compiler.tree.command;

import java.io.PrintStream;
import java.util.LinkedList;

import doxa.version2.compiler.tree.DeclGlobal;
import doxa.version2.compiler.tree.NomeComArgumentos;
import doxa.version2.compiler.tree.Tipo;
import symbolTable.SymbolTable;

public class DeclVariavel implements Comando, DeclGlobal {
	private LinkedList<String> idents;
	private Tipo tipo;
	private Boolean isGlobal = false;
	private String tipoJ;
	private LinkedList<Integer> indiceLocal = new LinkedList<Integer>();
	private static int countIndice;

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

	public void nextIndice() {
		this.countIndice++;
	}

	public String getTipoJ() {
		return this.tipoJ;
	}

	public void defTipoJ() {
		switch (this.tipo) {
		// define a letra do tipo para ser usado na geração de codigo
		case INT:
			this.tipoJ = "I";
			break;
		case FLOAT:
			this.tipoJ = "F";
			break;
		case CHAR:
			this.tipoJ = "C";
			break;
		}
	}

	public int getIndice(String id) {
		return this.indiceLocal.get(idents.indexOf(id));
	}

	@Override
	public Boolean verificarSemantica() {
		countIndice = SymbolTable.getInstance().getCountIndiceVar();
		for (int i = 0; i < idents.size(); i++) {
			if (SymbolTable.getInstance().nameExistsLocal(idents.get(i))) {
				System.out.println("Variável duplicada.");
				return false;
			} else { // se nao, adicione à tabela Global ou Local
				this.defTipoJ();
				if (SymbolTable.getInstance().isDeclGlobal()) {
					SymbolTable.getInstance().putGlobal(idents.get(i), tipo);
					isGlobal = true;
				} else {
					SymbolTable.getInstance().putLocal(idents.get(i), tipo);
					indiceLocal.add(countIndice);
					nextIndice();
					SymbolTable.getInstance().setCountIndiceVar(countIndice);
					isGlobal = false;
				}
			}
		}
		return true;
	}

	@Override
	public String gerarCodigo(PrintStream p) {

		if (isGlobal) {
			for (int i = 0; i < idents.size(); i++) {
				p.printf(".field private static %s %s \n", this.idents.get(i), this.getTipoJ());
			}
		} else { // decl local
			// nextIndice();
			for (int i = 0; i < idents.size(); i++) {
				// para saber o índice da variável local no array de Variáveis
				// Locais do JVM
				SymbolTable.getInstance().putLocal(idents.get(i), indiceLocal.get(i));
			}
		}
		return null;
	}

	public Boolean hasReturn() {
		return false;
	}
}
