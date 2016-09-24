package doxa.version1;


/**
 * Cada token é um par formado pelo lexema e a classificação dele.
 * 
 * @author Pablo Sampaio
 */
public class Token {
	private TokenType tipo;
	private String lexema;
	private int linha;
	private int coluna;

	public Token(TokenType tipo, int linha, int coluna) {
		this.tipo = tipo;
		this.linha = linha;
		this.coluna = coluna;
	}
	
	public Token(TokenType tipo, String lexema, int linha, int coluna) {
		this.tipo = tipo;
		this.lexema = lexema;
		this.linha = linha;
		this.coluna = coluna;
	}
	
	public TokenType getType() {
		return tipo;
	}
	
	public String getLexeme() {
		return lexema;
	}
	
	public String toString() {
		if (lexema == null || lexema.length() == 0) {
			return "[" + tipo + "]";	
		} else {
			return "[" + tipo + "," + lexema + "]";
		}
	}

	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}
	
}

