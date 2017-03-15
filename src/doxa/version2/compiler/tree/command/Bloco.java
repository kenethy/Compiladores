package doxa.version2.compiler.tree.command;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Bloco implements Comando {
	private List<Comando> comandos;

	public Bloco() {
		this.comandos = new ArrayList<Comando>();
	}

	public Bloco(List<Comando> comandos) {
		this.comandos = comandos;
	}

	public void add(Comando cmd) {
		this.comandos.add(cmd);
	}

	@Override
	public Boolean verificarSemantica() {
		Boolean r = true;
		for (int i = 0; i < comandos.size(); i++) {
			r = comandos.get(i).verificarSemantica();
			if (!r) {
				break;
			}
		}
		return r;
	}

	@Override
	public String gerarCodigo(PrintStream p) {
		for (int i = 0; i < comandos.size(); i++) {
			comandos.get(i).gerarCodigo(p);
		}
		return null;
	}
	
	public Boolean hasReturn() {
		for (int i =0; i<comandos.size(); i++){
			if(comandos.get(i) instanceof Retorno)
				return true;
		}
		return false;
	}
}
