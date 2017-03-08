package doxa.version2.compiler.tree.command;

import doxa.version2.compiler.tree.Tipo;
import doxa.version2.compiler.tree.expression.Expressao;
import symbolTable.SymbolTable;

public class Atribuicao implements Comando {
	private String identificador;
	private Expressao expressao;

	public Atribuicao(String ident, Expressao expressao) {
		this.identificador = ident;
		this.expressao = expressao;
	}

	@Override
	public Boolean verificarSemantica() {
		expressao.verificarSemantica();
		Tipo idTipo = null;
		if (SymbolTable.getInstance().nameExistsLocal(identificador)) {
			idTipo = (Tipo) SymbolTable.getInstance().getLocal(identificador);

		} else if (SymbolTable.getInstance().nameExistsGlobal(identificador)) {
			idTipo = (Tipo) SymbolTable.getInstance().getGlobal(identificador);
		}

		if (expressao.getTipo() == idTipo) {
			return true;
		}
		System.out.println("Tipos incompatível na atribuição");
		return false;
	}

	@Override
	public String gerarCodigo(String filename) {
		return null;
	}

}
