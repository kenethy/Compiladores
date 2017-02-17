package doxa.version2.compiler.tree.expression;

import java.util.LinkedList;

import doxa.version2.compiler.tree.Tipo;
import doxa.version2.compiler.tree.command.Comando;

public class ChamadaFunc implements Expressao, Comando {
	private String identificador;
	private LinkedList<LinkedList<Expressao>> listas;
	

	public ChamadaFunc(String identificador, LinkedList<Expressao> listaExprs) {
		this.identificador = identificador;
		this.listas = new LinkedList<LinkedList<Expressao>>();
		this.listas.add(listaExprs);
	}
	
	public void addId (String id){
		this.identificador = this.identificador + "$" + id;  
	}
	
	public void addListExp(LinkedList<Expressao> listaExpr){
		this.listas.add(listaExpr);
	}
		
	
	@Override
	public Boolean verificarSemantica() {
		return null;
	}
	

	@Override
	public Tipo getTipo() {
		return null;
	}
	
	@Override
	public String gerarCodigoIntermediario(String filename) {
		return null;
	}
}
