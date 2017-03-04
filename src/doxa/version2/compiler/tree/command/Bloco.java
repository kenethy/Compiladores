package doxa.version2.compiler.tree.command;

import java.util.ArrayList;
import java.util.List;

import doxa.version2.compiler.tree.Tipo;

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
			if (r==false){
				System.out.println("Semantica do bloco incorreta.");
				break;
			}
		}
		return r;
	}

	@Override
	public String gerarCodigoIntermediario(String filename) {
		return null;
	}
}
