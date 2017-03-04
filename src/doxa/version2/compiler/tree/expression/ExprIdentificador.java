package doxa.version2.compiler.tree.expression;

import doxa.version2.compiler.tree.Tipo;
import symbolTable.SymbolTable;

public class ExprIdentificador implements Expressao {
	private String identificador;

	public ExprIdentificador(String identificador) {
		this.identificador = identificador;
	}

	@Override
	public Boolean verificarSemantica() {
		return null;
	}

	@Override
	public Tipo getTipo() {
		Tipo idTipo = null;
		if (SymbolTable.getInstance().nameExistsLocal(identificador)) {
			idTipo = (Tipo) SymbolTable.getInstance().getLocal(identificador);

		} else if (SymbolTable.getInstance().nameExistsGlobal(identificador)) {
			idTipo = (Tipo) SymbolTable.getInstance().getGlobal(identificador);
		}

		return idTipo;
	}

	@Override
	public String gerarCodigoIntermediario(String filename) {
		return null;
	}

}
