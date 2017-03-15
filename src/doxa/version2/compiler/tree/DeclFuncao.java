package doxa.version2.compiler.tree;

import java.io.PrintStream;

import doxa.version2.compiler.tree.command.Bloco;
import symbolTable.SymbolTable;

public class DeclFuncao implements DeclGlobal {
	private NomeComArgumentos nomesParams;
	private Bloco bloco;
	private Tipo tipo;
	private static int countIndiceVar = 0;

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
			SymbolTable.getInstance().disableFDeclGlobal();
			SymbolTable.getInstance().putGlobal(nomesParams.getId(), this);
			SymbolTable.getInstance().setTipoAtual(this.tipo);
		}
		boolean p = this.nomesParams.verificarSemantica() && this.bloco.verificarSemantica();
		SymbolTable.getInstance().setCountIndiceVar(nomesParams.getQtdArgs());
		SymbolTable.getInstance().setFDeclGlobal();
		SymbolTable.getInstance().clearLocal();
		SymbolTable.getInstance().setCountIndiceVar(0);
		return (p);
	}

	public Tipo getTipo() {
		return this.tipo;
	}

	public NomeComArgumentos getParams() {
		return this.nomesParams;
	}

	@Override
	public String gerarCodigo(PrintStream p) {
		String t = null;

		if (this.tipo == null)
			t = "V";
		else {
			switch (tipo) {
			case FLOAT:
				t = "F";
				break;

			case INT:
				t = "I";
				break;

			case CHAR:
				t = "C";
				break;
			}
		}
		if (nomesParams.getId().equals("main")) {
			p.print("\n.method public static main([Ljava/lang/String;)V\n\t.limit locals 10\n\t.limit stack 10\n\n");
		} else {
			p.printf("\n.method public static %s(%s)%s\n\t.limit locals 10\n\t.limit stack 10\n\n", nomesParams.getId(),
					nomesParams.getTipoCodigo(), t);
		}
		nomesParams.gerarCodigo(p);
		bloco.gerarCodigo(p);
		if (tipo == null)
			p.print("\treturn\n");
		p.print(".end method\n");

		return null;
	}

}
