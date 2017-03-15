package doxa.version2.compiler.tree;

import java.io.PrintStream;
import java.util.LinkedList;

import doxa.version2.compiler.tree.command.DeclVariavel;
import symbolTable.SymbolTable;

public class NomeComArgumentos {
	private LinkedList<LinkedList<DeclVariavel>> listas;
	private String identificador;
	private int qtdArgs = 0;

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
		this.listas.addLast(paramForm);
	}

	public int getQtdArgs() {
		return qtdArgs;
	}

	public Boolean verificarSemantica() {
		// laço pra iterar cada parentesis na declaração da Função ex.: proc
		// mdcDe *(* x - int *)* e *(* y - int *)* - int {
		for (int i = 0; i < listas.size(); i++) {
			if (listas.get(i) != null) {
				// laço para iterar cada Declaração dentro do parentesis ex.:
				// proc mdcDe(*x - int* , *j - char*)e(y - int) - int {
				for (int y = 0; y < listas.get(i).size(); y++) {
					DeclVariavel declaracao = listas.get(i).get(y);
					qtdArgs++;
					declaracao.defTipoJ();
					// getIdents().get(0) o tamanho dessa linkedList, nesse caso
					// específico, é sempre 1, segundo a gramática. Vide
					// DeclVariavel.idents
					if (SymbolTable.getInstance().nameExistsLocal(declaracao.getIdents().get(0))) {
						System.out.println("Parâmetro duplicado.");
						return false;
					} else { // se nao, adiciona na tabela local
						declaracao.verificarSemantica();
						SymbolTable.getInstance().putLocal(declaracao.getIdents().get(0), declaracao.getTipo());
					}
				}
			}
		}
		return true;
	}

	public String getTipoCodigo() {
		String r = "";
		for (int i = 0; i < listas.size(); i++) {
			if (listas.get(i) != null) {
				for (int y = 0; y < listas.get(i).size(); y++) {
					DeclVariavel declaracao = listas.get(i).get(y);
					r = r + declaracao.getTipoJ();
				}
			}
		}
		return r;
	}

	public LinkedList<LinkedList<DeclVariavel>> getListas() {
		return this.listas;
	}

	public String gerarCodigo(PrintStream p) {
		for (int i = 0; i < listas.size(); i++) {
			if (listas.get(i) != null) {
				for (int y = 0; y < listas.get(i).size(); y++) {
					listas.get(i).get(y).gerarCodigo(p);
				}
			}
		}
		return null;
	}
}
