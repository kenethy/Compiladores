package doxa.version2.compiler.tree.expression;

import java.io.PrintStream;

import doxa.version2.compiler.tree.Tipo;
import symbolTable.SymbolTable;

public class ExprIdentificador implements Expressao {
	private String identificador;
	private Tipo tipo;

	public ExprIdentificador(String identificador) {
		this.identificador = identificador;
	}

	@Override
	public Boolean verificarSemantica() {
		if (SymbolTable.getInstance().nameExistsLocal(identificador)) {
			setTipo((Tipo) SymbolTable.getInstance().getLocal(identificador));
			return true;
		} else if (SymbolTable.getInstance().nameExistsGlobal(identificador)) {
			setTipo((Tipo) SymbolTable.getInstance().getGlobal(identificador));
			return true;
		} else {
			System.out.println("Variável não existe");
			return false;
		}

	}

	public void setTipo(Tipo e) {
		this.tipo = e;
	}

	@Override
	public Tipo getTipo() {
		return this.tipo;
	}

	@Override
	public String gerarCodigo(PrintStream p) {
		Boolean isLocal = false;
		if (SymbolTable.getInstance().nameExistsLocal(identificador))
			isLocal = true;
		switch (tipo) {
		case INT:
			if (isLocal)
				p.printf("\tiload_%d\n", SymbolTable.getInstance().getLocal(identificador));
			else
				p.printf("\tgetstatic Codigo/%s I", identificador);
			break;
		case FLOAT:
			if (isLocal)
				p.printf("\tfload_%d\n", SymbolTable.getInstance().getLocal(identificador));
			else
				p.printf("\tgetstatic Codigo/%s F", identificador);
			break;
		case CHAR:
			if (isLocal)
				p.printf("\tiload_%d\n", SymbolTable.getInstance().getLocal(identificador));
			else
				p.printf("\tgetstatic Codigo/%s C", identificador);
			break;
		}
		return null;
	}

}
