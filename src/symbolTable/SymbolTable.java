package symbolTable;

import java.util.HashMap;

import doxa.version2.compiler.tree.Tipo;

public class SymbolTable {
	private HashMap<String, Object> hmLocal;
	private HashMap<String, Object> hmGlobal;
	private Tipo tipoAtual = null;
	private Boolean fDeclGlobal = true;
	private int countIndiceVar = 0;
	private static SymbolTable instance = null;

	public SymbolTable() {
		hmLocal = new HashMap<String, Object>();
		hmGlobal = new HashMap<String, Object>();
	}

	public static SymbolTable getInstance() {
		if (instance == null) {
			instance = new SymbolTable();
			return instance;
		}
		return instance;
	}

	public int getCountIndiceVar() {
		return countIndiceVar;
	}

	public void setCountIndiceVar(int countIndiceVar) {
		this.countIndiceVar = countIndiceVar;
	}

	public void setFDeclGlobal() {
		this.fDeclGlobal = true;
	}

	public void disableFDeclGlobal() {
		this.fDeclGlobal = false;
	}

	public Boolean isDeclGlobal() {
		if (fDeclGlobal)
			return true;
		return false;
	}

	public Tipo getTipoAtual() {
		return this.tipoAtual;
	}

	public void setTipoAtual(Tipo t) {
		this.tipoAtual = t;
	}

	public void clearLocal() {
		this.hmLocal.clear();
	}

	// retorna True se o nome existe na tabela
	public boolean nameExistsGlobal(String name) {
		if (hmGlobal.containsKey(name))
			return true;
		return false;
	}

	// retorna True se o nome existe na tabela
	public boolean nameExistsLocal(String name) {
		if (hmLocal.containsKey(name))
			return true;
		return false;
	}

	public Object getLocal(String chave) {
		if (hmLocal.containsKey(chave))
			return hmLocal.get(chave);
		return null;
	}

	public Object getGlobal(String chave) {
		if (hmGlobal.containsKey(chave))
			return hmGlobal.get(chave);
		return null;
	}

	public void putGlobal(String nome, Object objeto) {
		hmGlobal.put(nome, objeto);
	}

	public void putLocal(String nome, Object objeto) {
		hmLocal.put(nome, objeto);
	}
}
