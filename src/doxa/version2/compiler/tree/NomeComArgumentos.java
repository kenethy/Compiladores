package doxa.version2.compiler.tree;

import java.util.LinkedList;
import java.util.List;

import doxa.version2.compiler.tree.command.DeclVariavel;
import doxa.version2.compiler.tree.expression.Expressao;
import symbolTable.SymbolTable;

public class NomeComArgumentos {
	private LinkedList<LinkedList<DeclVariavel>> listas;
	private String identificador;

	public NomeComArgumentos(String identificar, LinkedList<DeclVariavel> paramFormais) {
		this.listas = new LinkedList<LinkedList<DeclVariavel>>();
		this.listas.add(paramFormais);
		this.identificador = identificar;
	}

	public void addId(String id) {
		this.identificador = this.identificador + "$" + id;
	}

	public String getId() {
		return this.identificador;
	}

	public void addParamForm(LinkedList<DeclVariavel> paramForm) {
		this.listas.add(paramForm);
	}

	public Boolean verificarSemantica() {
		// la�o pra iterar cada parentesis na declara��o da Fun��o ex.: proc mdcDe *(* x - int *)* e *(* y - int *)* - int {
		for (int i = 0; i < listas.size(); i++) {
			if (listas.get(i) != null) {
				// la�o para iterar cada Declara��o dentro do parentesis ex.: proc mdcDe(*x - int* , *j - char*)e(y - int) - int {
				for (int y = 0; y < listas.get(i).size(); y++) {
					DeclVariavel declaracao = listas.get(i).get(y);
					// getIdents().get(0) o tamanho dessa linkedList, nesse caso espec�fico, � sempre 1, segundo a gram�tica. Vide DeclVariavel.idents
					if (SymbolTable.getInstance().nameExistsLocal(declaracao.getIdents().get(0))) {
						System.out.println("Par�metro duplicado.");
						return false;
					} else { // se nao, adiciona na tabela local
						SymbolTable.getInstance().putLocal(declaracao.getIdents().get(0), declaracao.getTipo());
					}
				}
			}
		}
		return true;
	}

	public String gerarCodigoIntermediario(String filename) {
		return null;
	}
}
