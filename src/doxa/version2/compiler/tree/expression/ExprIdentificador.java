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
		if (SymbolTable.getInstance().nameExistsLocal(identificador))
			return true;
		else if(SymbolTable.getInstance().nameExistsGlobal(identificador))
			return true;
		else {
			System.out.println("Variável não existe");
			return false;
		}
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
	public String gerarCodigo(String filename) {
		return null;
	}

}
