package symbolTable;

import java.util.HashMap;

public class SymbolTable {
	private HashMap<String, Object> hmLocal;
	private HashMap<String, Object> hmGlobal;
	private static SymbolTable instance = null;
	
	public SymbolTable(){
		hmLocal = new HashMap<String, Object>();
		hmGlobal = new HashMap<String, Object>();
	}
	
	public static SymbolTable getInstance(){
		if (instance == null){
			instance = new SymbolTable();
			return instance;
		}
		return instance;
		
	}
	
	public void clearLocal(){
		this.hmLocal.clear();
	}
	
	public boolean nameExistsGlobal(String name) { // retorna True se o nome existe na tabela
		if (hmGlobal.containsKey(name))
			return true;
		return false;
	}
	
	public boolean nameExistsLocal(String name) { // retorna True se o nome existe na tabela
		if (hmLocal.containsKey(name))
			return true;
		return false;
	}
	
	public Object getLocal(String chave){
		if (hmLocal.containsKey(chave))
			return hmLocal.get(chave);
		return null;
	}
	
	public Object getGlobal(String chave){
		if (hmGlobal.containsKey(chave))
			return hmGlobal.get(chave);
		return null;
	}
	
	public void putGlobal(String nome, Object objeto){
		hmGlobal.put(nome, objeto);	
	}
	
	public void putLocal(String nome, Object objeto){
		hmLocal.put(nome, objeto);	
	}
	
}
