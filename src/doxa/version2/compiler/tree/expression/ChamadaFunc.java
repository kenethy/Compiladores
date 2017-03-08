package doxa.version2.compiler.tree.expression;

import java.util.LinkedList;

import doxa.version2.compiler.tree.Tipo;
import doxa.version2.compiler.tree.DeclFuncao;
import doxa.version2.compiler.tree.command.Comando;
import doxa.version2.compiler.tree.command.DeclVariavel;
import symbolTable.SymbolTable;

public class ChamadaFunc implements Expressao, Comando {
	private String identificador;
	private LinkedList<LinkedList<Expressao>> listas;
	private Tipo tipo;

	public ChamadaFunc(String identificador, LinkedList<Expressao> listaExprs) {
		this.identificador = identificador;
		this.listas = new LinkedList<LinkedList<Expressao>>();
		this.listas.add(listaExprs);
	}

	public void addId(String id) {
		this.identificador = this.identificador + "$" + id;
	}

	public void addListExp(LinkedList<Expressao> listaExpr) {
		this.listas.addLast(listaExpr);
	}

	@Override
	public Boolean verificarSemantica() {
		DeclFuncao funcao = null;
		// regra 11
		if (SymbolTable.getInstance().nameExistsGlobal(identificador)) {
			funcao = (DeclFuncao) SymbolTable.getInstance().getGlobal(identificador);
			tipo = funcao.getTipo();
			for (int i = 0; i < funcao.getParams().getListas().size(); i++) {
				if (funcao.getParams().getListas().get(i).size() == listas.get(i).size()) {
					for (int y = 0; y < funcao.getParams().getListas().get(i).size(); y++) {
						listas.get(i).get(y).verificarSemantica();
						if (funcao.getParams().getListas().get(i).get(y).getTipo() != listas.get(i).get(y).getTipo()) {
							System.out.println("Ordem dos parametros na chamada da função incorretos");
							return false;
						}
					}
				} else {
					System.out.println("Quantidade de parametros incorreta");
					return false;
				}
			}
		} else {
			System.out.println("Função não existe");
			return false;
		}

		return true;
	}

	@Override
	public Tipo getTipo() {
		return this.tipo;
	}

	@Override
	public String gerarCodigo(String filename) {
		return null;
	}
}
