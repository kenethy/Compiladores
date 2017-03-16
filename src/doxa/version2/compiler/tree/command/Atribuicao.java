package doxa.version2.compiler.tree.command;

import java.io.PrintStream;

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
	public String gerarCodigo(PrintStream p) {
		expressao.gerarCodigo(p);
		int pos = (int) SymbolTable.getInstance().getLocal(identificador);
		switch (expressao.getTipo()) {
		case INT:
			p.printf("\tistore_%d\n\n", pos);
			break;
		case FLOAT:
			p.printf("\tfstore_%d\n\n", pos);
			break;
		case CHAR:
			p.printf("\tistore_%d\n\n", pos);
			break;
		}
		return null;
	}

	public Boolean hasReturn() {
		return false;
	}

}
