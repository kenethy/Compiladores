package doxa.version2.compiler.tree;

import doxa.version2.compiler.tree.command.Bloco;
import symbolTable.SymbolTable;

public class DeclFuncao implements DeclGlobal {
	private NomeComArgumentos nomesParams;
	private Bloco bloco;
	private Tipo tipo;

	public DeclFuncao(NomeComArgumentos assinatura, Tipo tipo, Bloco bloco) {
		this.nomesParams = assinatura;
		this.bloco = bloco;
		this.tipo = tipo;
	}

	public DeclFuncao(NomeComArgumentos assinatura, Bloco bloco) {
		this.nomesParams = assinatura;
		this.bloco = bloco;
	}

	@Override
	public Boolean verificarSemantica() {
		// verificar se a funcao ja foi declarada
		if (SymbolTable.getInstance().nameExistsGlobal(nomesParams.getId())) {
			System.out.println("Função com mesmo nome já declarada.");

			return false;
		} else { // se nao, adicione à tabela
			SymbolTable.getInstance().putGlobal(nomesParams.getId(), this);
		}
		boolean p = this.nomesParams.verificarSemantica() && this.bloco.verificarSemantica();
		SymbolTable.getInstance().clearLocal();
		return (p);
	}

	public Tipo getTipo() {
		return this.tipo;
	}

	public NomeComArgumentos getParams() {
		return this.nomesParams;
	}

	@Override
	public String gerarCodigoIntermediario(String filename) {
		return null;
	}

}
