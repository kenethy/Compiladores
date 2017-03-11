package doxa.version2.compiler.tree;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public interface DeclGlobal {
	Boolean verificarSemantica() ;
	String gerarCodigo(PrintStream p);
}
