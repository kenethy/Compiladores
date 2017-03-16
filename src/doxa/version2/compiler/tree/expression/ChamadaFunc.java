package doxa.version2.compiler.tree.expression;

import java.io.PrintStream;
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
	private String tipoJ;

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

	public void setTipoJ() {
		switch (tipo) {
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

	public String getTipoCodigo() {
		String r = "";
		String tipoJ1 = null;
		for (int i = 0; i < listas.size(); i++) {
			if (listas.get(i) != null) {
				for (int y = 0; y < listas.get(i).size(); y++) {
					Expressao exp = listas.get(i).get(y);
					switch (exp.getTipo()) {
					case INT:
						tipoJ1 = "I";
						break;
					case FLOAT:
						tipoJ1 = "F";
						break;
					case CHAR:
						tipoJ1 = "C";
						break;
					}
					r = r + tipoJ1;
				}
			}
		}
		return r;
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
						setTipoJ();
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
	public String gerarCodigo(PrintStream p) {
		for (int i = 0; i < listas.size(); i++) {
			for (int y = 0; y < listas.get(i).size(); y++) {
				listas.get(i).get(y).gerarCodigo(p);
			}
		}
		p.println("\tinvokestatic " + "Codigo/" + identificador + "(" + getTipoCodigo() + ")" + this.tipoJ);
		return null;
	}

	@Override
	public Boolean hasReturn() {
		return false;
	}
}
