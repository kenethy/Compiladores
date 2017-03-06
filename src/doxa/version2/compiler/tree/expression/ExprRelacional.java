package doxa.version2.compiler.tree.expression;

import doxa.version2.compiler.tree.Tipo;

public class ExprRelacional implements Expressao {

	private Expressao expr1;
	private Expressao expr2;
	private String operador;
	private Tipo tipo;

	public ExprRelacional(Expressao expr1, Expressao expr2, String operador) {
		this.expr1 = expr1;
		this.expr2 = expr2;
		this.operador = operador;
	}
	
	@Override
	public Boolean verificarSemantica() {
		expr1.verificarSemantica();
		expr2.verificarSemantica();
		
		//regra 7 e 8
		if (expr1.getTipo() == expr2.getTipo() && (expr1.getTipo()==Tipo.INT || expr1.getTipo()==Tipo.FLOAT)){
			if(operador.equals("<") || operador.equals("<=") || operador.equals(">") || operador.equals(">=") || operador.equals("=") || operador.equals("<>")){
				this.tipo = Tipo.BOOLEAN;
			}
			else{
				System.out.println("Operador relacional incorreto");
				return false;
			}
			//regra 8
		} else if(expr1.getTipo() == expr2.getTipo() && expr1.getTipo() == Tipo.CHAR){
			if(operador.equals("=") || operador.equals("<>"))
				this.tipo = Tipo.BOOLEAN;
			else{
				System.out.println("Operador relacional incorreto");
				return false;
			}
		}
			
		else{
			System.out.println("Expressão relacional incorreta");
			return false;
		}
		return true;
	}

	@Override
	public Tipo getTipo() {
		return this.tipo;
	}
	
	@Override
	public String gerarCodigoIntermediario(String filename) {
		return null;
	}

}
