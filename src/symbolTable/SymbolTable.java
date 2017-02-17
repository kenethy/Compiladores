package symbolTable;

import java.util.HashMap;

public class SymbolTable {
	private HashMap<String, Object> hmLocal;
	private HashMap<String, Object> hmGlobal;
	private SymbolTable instance = this;
	
	public SymbolTable(){
		
	}
	
	public SymbolTable getInstance(){
		if (instance == null)
			return new SymbolTable();
		return instance;
		
	}
	
	public Object get(){
		return null;
	}
	
	public void put(String nome, Object objeto){
		
	}
	
}
