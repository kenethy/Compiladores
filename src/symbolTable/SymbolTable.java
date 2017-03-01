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
	
	public boolean nameExists(String name){ // retorna True se o nome existe na tabela
		if (hmLocal.containsKey(name))
			return true;
		return false;
	}
	
	public Object get(){
		return null;
	}
	
	public void putGlobal(String nome, Object objeto){
		hmGlobal.put(nome, objeto);
		
	}
	
}
