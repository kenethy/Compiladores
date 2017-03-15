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
		for (int i = 0; i < listaExpressoes.size(); i++) {
			if (!listaExpressoes.get(i).verificarSemantica())
				return false;
		}
		return true;
	}

	@Override
	public String gerarCodigo(PrintStream p) {
		for (int i = 0; i < listaExpressoes.size(); i++) {
			// carregar classe de imprimir na saída padrao JVM
			p.println("\tgetstatic java/lang/System/out Ljava/io/PrintStream;");
			listaExpressoes.get(i).gerarCodigo(p);
			switch (listaExpressoes.get(i).getTipo()) {
			case INT:
				p.println("\tinvokevirtual java/io/PrintStream/print(I)V");
				break;
			case FLOAT:
				p.println("\tinvokevirtual java/io/PrintStream/print(F)V");
				break;
			case CHAR:
				p.println("\tinvokevirtual java/io/PrintStream/print(C)V");
				break;
			}
		}
		p.println();
		return null;
	}
	
	public Boolean hasReturn() {
		return false;
	}
}
