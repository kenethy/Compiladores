package doxa.version2.compiler.tree.command;	

import java.io.PrintStream;

import doxa.version2.compiler.tree.Tipo;
import doxa.version2.compiler.tree.expression.Expressao;
import symbolTable.SymbolTable;

public class Retorno implements Comando {
	private Expressao expressao;

	public Retorno(Expressao expr) {
		this.expressao = expr;
	}

	@Override
	public Boolean verificarSemantica() {
		if (!expressao.verificarSemantica())
			return false;
		if(expressao.getTipo() == SymbolTable.getInstance().getTipoAtual())
			return true;
		else{
			System.out.println("Tipo incompatível com o retorno da função.");
			return false;
		}
	}

	@Override
	public String gerarCodigo(PrintStream p) {
		return null;
	}

}
