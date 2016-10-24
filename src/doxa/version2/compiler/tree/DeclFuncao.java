package doxa.version2.compiler.tree;

import doxa.version2.compiler.tree.command.Bloco;

public class DeclFuncao implements DeclGlobal {
	private NomeComArgumentos nomesParams;
	private Bloco bloco;
	private Tipo tipo;
	
	public DeclFuncao(NomeComArgumentos assinatura, Bloco bloco) {
		this.nomesParams = assinatura;
		this.bloco = bloco;
	}

	@Override
	public Boolean verificarSemantica() {
		return null;
	}

	@Override
	public String gerarCodigoIntermediario(String filename) {
		return null;
	}

}
