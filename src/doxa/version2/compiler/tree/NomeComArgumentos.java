package doxa.version2.compiler.tree;

import java.util.LinkedList;
import java.util.List;

import doxa.version2.compiler.tree.command.DeclVariavel;
import doxa.version2.compiler.tree.expression.Expressao;

public class NomeComArgumentos {
	private LinkedList<LinkedList<DeclVariavel>> listas;
	private String identificador;

	public NomeComArgumentos(String identificar, LinkedList<DeclVariavel> paramFormais) {
		this.listas = new LinkedList<LinkedList<DeclVariavel>>();
		this.listas.add(paramFormais);
		this.identificador = identificar;
	}
	
	public void addId (String id){
		this.identificador = this.identificador + "$" + id;  
	}
	
	public String getId(){
		return this.identificador;
	}
	
	public void addParamForm(LinkedList<DeclVariavel> paramForm){
		this.listas.add(paramForm);
	}

	public Boolean verificarSemantica() {
		return null;
	}

	public String gerarCodigoIntermediario(String filename) {
		return null;
	}
}
