package doxa.version2.compiler.tree;

import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedList;

public class Programa {
	private LinkedList<DeclGlobal> declaracoes;

	public Programa() {
		declaracoes = new LinkedList<DeclGlobal>();
	}

	public void addLast(DeclGlobal dec) {
		this.declaracoes.addLast(dec);
	}

	public Boolean verificarSemantica() {
		Boolean r = true;
		for (int i = 0; i < declaracoes.size(); i++) {
			r = declaracoes.get(i).verificarSemantica();
			if (r == false)
				break;
		}
		return r;
	}

	public String gerarCodigo(String filename) throws IOException {
		PrintStream p = new PrintStream(filename);
		
		p.print(".class public Codigo\n"
					+ ".super java/lang/Object\n\n");
		
		for (int i = 0; i < declaracoes.size(); i++) {
			declaracoes.get(i).gerarCodigo(p);
		}
		
		p.print("\n.method public <init>()V\n"
						+ "\taload_0\n"
						+ "\tinvokenonvirtual java/lang/Object/<init>()V\n"
						+ "\treturn\n"
					+ ".end method\n\n");
		
		p.close();
		return null;
	}
}