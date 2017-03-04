package doxa.version2.compiler.tree.command;

import doxa.version2.compiler.tree.Tipo;
import doxa.version2.compiler.tree.expression.Expressao;

public class Decisao implements Comando {
	private Expressao expressao;
	private Comando comandoIf;
	private Comando comandoElse;

	/**
	 * Construtor para if-else completo.
	 */
	public Decisao(Expressao expr, Comando cmdIf, Comando cmdElse) {
		this.expressao = expr;
		this.comandoIf = cmdIf;
		this.comandoElse = cmdElse;
	}

	/**
	 * Construtor para if sem else.
	 */
	public Decisao(Expressao expr, Comando cmdIf) {
		this.expressao = expr;
		this.comandoIf = cmdIf;
	}

	@Override
	public Boolean verificarSemantica() {
		this.expressao.verificarSemantica();
		if (this.expressao.getTipo() == Tipo.BOOLEAN){
			if (this.comandoIf.verificarSemantica() == false)
				return false;
			if (comandoElse != null)
				if(this.comandoElse.verificarSemantica() == false);
					return false;
		}
		
		return true;
	}

	@Override
	public String gerarCodigoIntermediario(String filename) {
		return null;
	}

}
