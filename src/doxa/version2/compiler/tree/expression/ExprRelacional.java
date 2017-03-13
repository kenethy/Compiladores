package doxa.version2.compiler.tree.expression;

import java.io.PrintStream;

import doxa.version2.compiler.tree.Tipo;

public class ExprRelacional implements Expressao {

	private Expressao expr1;
	private Expressao expr2;
	private String operador;
	private Tipo tipo;
	private static int labelCount;

	public ExprRelacional(Expressao expr1, Expressao expr2, String operador) {
		this.expr1 = expr1;
		this.expr2 = expr2;
		this.operador = operador;
	}
	
	public void nextLabelCount(){
		labelCount++;
	}
	
	public int getLabelCount(){
		int r = labelCount;
		return r;
	}

	@Override
	public Boolean verificarSemantica() {
		expr1.verificarSemantica();
		expr2.verificarSemantica();

		// regra 7 e 8
		if (expr1.getTipo() == expr2.getTipo() && (expr1.getTipo() == Tipo.INT || expr1.getTipo() == Tipo.FLOAT)) {
			if (operador.equals("<") || operador.equals("<=") || operador.equals(">") || operador.equals(">=")
					|| operador.equals("=") || operador.equals("<>")) {
				this.tipo = Tipo.BOOLEAN;
			} else {
				System.out.println("Operador relacional incorreto");
				return false;
			}
			// regra 8
		} else if (expr1.getTipo() == expr2.getTipo() && expr1.getTipo() == Tipo.CHAR) {
			if (operador.equals("=") || operador.equals("<>"))
				this.tipo = Tipo.BOOLEAN;
			else {
				System.out.println("Operador relacional incorreto");
				return false;
			}
		}

		else {
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
	public String gerarCodigo(PrintStream p) {
		expr1.gerarCodigo(p);
		expr2.gerarCodigo(p);
		switch (this.operador) {
		case "=":
			if (expr1.getTipo() == Tipo.INT ||  expr1.getTipo() == Tipo.CHAR) {
				p.println("\tif_icmpeq equal"+getLabelCount());
				p.println("\ticonst_0\n\tgoto depoisE"+getLabelCount());
				p.println("equal"+getLabelCount()+":\n \ticonst_1");
				p.println("depoisE"+getLabelCount()+":\n");
			} else if (expr1.getTipo() == Tipo.FLOAT) {
				p.println("\tfcmpg");
				p.println("\tifeq equal"+getLabelCount());
				p.println("\ticonst_0\n\tgoto depoisE"+getLabelCount());
				p.println("equal"+getLabelCount()+":\n \ticonst_1");
				p.println("depoisE"+getLabelCount()+":\n");
			}
			break;
		case ">":
			if (expr1.getTipo() == Tipo.INT) {
				p.println("\tif_icmpgt greater"+getLabelCount());
				p.println("\ticonst_0\n\tgoto depoisG"+getLabelCount());
				p.println("greater"+getLabelCount()+":\n \ticonst_1");
				p.println("depoisG"+getLabelCount()+":\n");
			} else if (expr1.getTipo() == Tipo.FLOAT) {
				p.println("\tfcmpg");
				p.println("\tifgt greater"+getLabelCount());
				p.println("\ticonst_0\n\tgoto depoisG"+getLabelCount());
				p.println("greater"+getLabelCount()+":\n \ticonst_1");
				p.println("depoisG"+getLabelCount()+":\n");
			}
			break;
		case "<":
			if (expr1.getTipo() == Tipo.INT) {
				p.println("\tif_icmplt less"+getLabelCount());
				p.println("\ticonst_0\n\tgoto depoisL"+getLabelCount());
				p.println("less"+getLabelCount()+":\n \ticonst_1");
				p.println("depoisL"+getLabelCount()+":\n");
			} else if (expr1.getTipo() == Tipo.FLOAT) {
				p.println("\tfcmpg");
				p.println("\tiflt less"+getLabelCount());
				p.println("\ticonst_0\n\tgoto depoisL"+getLabelCount());
				p.println("less"+getLabelCount()+":\n \ticonst_1");
				p.println("depoisL"+getLabelCount()+":\n");
			}
			break;
		case ">=":
			if (expr1.getTipo() == Tipo.INT) {
				p.println("\tif_icmpge greaterEQ"+getLabelCount());
				p.println("\ticonst_0\n\tgoto depoisGE"+getLabelCount());
				p.println("greaterEQ"+getLabelCount()+":\n \ticonst_1");
				p.println("depoisGE"+getLabelCount()+":\n");
			} else if (expr1.getTipo() == Tipo.FLOAT) {
				p.println("\tfcmpg");
				p.println("\tifge greaterEQ"+getLabelCount());
				p.println("\ticonst_0\n\tgoto depoisGE"+getLabelCount());
				p.println("greaterEQ"+getLabelCount()+":\n \ticonst_1");
				p.println("depoisGE"+getLabelCount()+":\n");
			}
			break;
		case "<=":
			if (expr1.getTipo() == Tipo.INT) {
				p.println("\tif_icmple lessEq"+getLabelCount());
				p.println("\ticonst_0\n\tgoto depoisLE"+getLabelCount());
				p.println("lessEq"+getLabelCount()+":\n \ticonst_1");
				p.println("depoisLE"+getLabelCount()+":\n");
			} else if (expr1.getTipo() == Tipo.FLOAT) {
				p.println("\tfcmpg");
				p.println("\tifle lessEq"+getLabelCount());
				p.println("\ticonst_0\n\tgoto depoisLE"+getLabelCount());
				p.println("lessEq"+getLabelCount()+":\n \ticonst_1");
				p.println("depoisLE"+getLabelCount()+":\n");
			}
			break;
		case "<>":
			if (expr1.getTipo() == Tipo.INT || expr1.getTipo() == Tipo.CHAR) {
				p.println("\tif_icmpne nigual"+getLabelCount());
				p.println("\ticonst_0\n\tgoto depoisNE"+getLabelCount());
				p.println("nigual"+getLabelCount()+":\n \ticonst_1");
				p.println("depoisNE"+getLabelCount()+":\n");
			} else if (expr1.getTipo() == Tipo.FLOAT) {
				p.println("\tfcmpg");
				p.println("\tifne nigual"+getLabelCount());
				p.println("\ticonst_0\n\tgoto depoisNE"+getLabelCount());
				p.println("nigual"+getLabelCount()+":\n \ticonst_1");
				p.println("depoisNE"+getLabelCount()+":\n");
			}
			break;
		}
		nextLabelCount();
		return null;
	}

}
