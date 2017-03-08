package doxa.version2.compiler.tree;

public interface DeclGlobal {
	Boolean verificarSemantica() ;
	String gerarCodigo(String filename);
}
