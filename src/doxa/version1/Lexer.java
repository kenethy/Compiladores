/* The following code was generated by JFlex 1.4.1 on 12/09/16 14:31 */

package doxa.version1;

/* 	Projeto Vers�o 1 - Compiladores
	
		Alunos
	---------------
	Ikaro Alef
	Kenedy Felipe
*/


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.1
 * on 12/09/16 14:31 from the specification file
 * <tt>C:/Users/m2m/workspace/Compiladores/src/doxa/version1/Lexer.flex</tt>
 */
public class Lexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = {
     0,  0,  0,  0,  0,  0,  0,  0,  0,  1, 38,  0,  1,  1,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     1,  0,  0,  0,  0, 13,  0,  0, 22, 21, 11,  9, 23, 10,  5, 12, 
     4,  4,  4,  4,  4,  4,  4,  4,  4,  4, 20, 24,  6,  8,  7,  0, 
     0,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3, 
     3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  0,  0,  0,  0,  3, 
     0, 14,  2, 35, 16, 29, 28,  2, 33, 27,  2,  2, 30,  2, 15, 17, 
    37,  2, 18, 31, 19, 34, 36, 32,  2,  2,  2, 25,  0, 26,  0,  0
  };

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\1\1\5\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\4\3\1\1"+
    "\1\15\1\16\1\17\1\20\1\21\1\22\7\3\1\23"+
    "\1\24\1\25\1\26\1\27\2\3\1\30\1\3\1\31"+
    "\1\3\1\32\7\3\1\23\1\0\1\33\1\34\1\3"+
    "\1\35\4\3\1\36\5\3\1\37\1\3\1\40\1\41"+
    "\1\42\1\43\1\3\1\44\1\45\1\46";

  private static int [] zzUnpackAction() {
    int [] result = new int[77];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\47\0\116\0\165\0\234\0\303\0\352\0\u0111"+
    "\0\47\0\47\0\47\0\u0138\0\47\0\47\0\u015f\0\u0186"+
    "\0\u01ad\0\u01d4\0\u01fb\0\47\0\47\0\47\0\47\0\47"+
    "\0\47\0\u0222\0\u0249\0\u0270\0\u0297\0\u02be\0\u02e5\0\u030c"+
    "\0\u0333\0\47\0\47\0\47\0\u035a\0\u0381\0\u03a8\0\165"+
    "\0\u03cf\0\47\0\u03f6\0\165\0\u041d\0\u0444\0\u046b\0\u0492"+
    "\0\u04b9\0\u04e0\0\u0507\0\u052e\0\303\0\165\0\165\0\u0555"+
    "\0\165\0\u057c\0\u05a3\0\u05ca\0\u05f1\0\165\0\u0618\0\u063f"+
    "\0\u0666\0\u068d\0\u06b4\0\165\0\u06db\0\165\0\165\0\165"+
    "\0\165\0\u0702\0\165\0\165\0\165";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[77];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\2\1\5\1\6\1\7\1\10"+
    "\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20"+
    "\1\4\1\21\1\22\1\4\1\23\1\24\1\25\1\26"+
    "\1\27\1\30\1\31\1\32\1\33\1\34\2\4\1\35"+
    "\2\4\1\36\1\37\1\40\1\3\50\0\1\3\44\0"+
    "\1\3\2\0\3\4\11\0\6\4\7\0\13\4\5\0"+
    "\1\5\1\41\45\0\1\41\51\0\1\42\1\43\46\0"+
    "\1\44\51\0\1\45\35\0\3\4\11\0\1\4\1\46"+
    "\4\4\7\0\13\4\3\0\3\4\11\0\3\4\1\47"+
    "\2\4\7\0\13\4\3\0\3\4\11\0\4\4\1\50"+
    "\1\4\7\0\13\4\3\0\3\4\11\0\6\4\7\0"+
    "\2\4\1\51\10\4\11\0\1\52\40\0\3\4\11\0"+
    "\1\4\1\53\4\4\7\0\1\4\1\54\11\4\3\0"+
    "\3\4\11\0\6\4\7\0\3\4\1\55\7\4\3\0"+
    "\3\4\11\0\6\4\7\0\3\4\1\56\7\4\3\0"+
    "\3\4\11\0\6\4\7\0\6\4\1\57\4\4\3\0"+
    "\3\4\11\0\6\4\7\0\6\4\1\60\4\4\3\0"+
    "\3\4\11\0\1\61\2\4\1\62\2\4\7\0\13\4"+
    "\3\0\3\4\11\0\4\4\1\63\1\4\7\0\13\4"+
    "\5\0\1\64\1\65\41\0\46\45\3\0\3\4\11\0"+
    "\2\4\1\66\3\4\7\0\13\4\3\0\3\4\11\0"+
    "\5\4\1\67\7\0\13\4\3\0\3\4\11\0\5\4"+
    "\1\70\7\0\13\4\3\0\3\4\11\0\5\4\1\71"+
    "\7\0\13\4\3\0\3\4\11\0\3\4\1\72\2\4"+
    "\7\0\13\4\3\0\3\4\11\0\6\4\7\0\4\4"+
    "\1\73\6\4\3\0\3\4\11\0\6\4\7\0\1\74"+
    "\12\4\3\0\3\4\11\0\1\75\5\4\7\0\13\4"+
    "\3\0\3\4\11\0\4\4\1\76\1\4\7\0\13\4"+
    "\3\0\3\4\11\0\6\4\7\0\1\77\12\4\3\0"+
    "\3\4\11\0\1\4\1\100\1\4\1\101\2\4\7\0"+
    "\13\4\5\0\1\64\1\41\43\0\3\4\11\0\6\4"+
    "\7\0\7\4\1\102\3\4\3\0\3\4\11\0\1\103"+
    "\5\4\7\0\13\4\3\0\3\4\11\0\6\4\7\0"+
    "\2\4\1\104\10\4\3\0\3\4\11\0\6\4\7\0"+
    "\3\4\1\105\7\4\3\0\3\4\11\0\4\4\1\106"+
    "\1\4\7\0\13\4\3\0\3\4\11\0\2\4\1\107"+
    "\3\4\7\0\13\4\3\0\3\4\11\0\5\4\1\110"+
    "\7\0\13\4\3\0\3\4\11\0\6\4\7\0\10\4"+
    "\1\111\2\4\3\0\3\4\11\0\4\4\1\112\1\4"+
    "\7\0\13\4\3\0\3\4\11\0\5\4\1\113\7\0"+
    "\13\4\3\0\3\4\11\0\6\4\7\0\2\4\1\114"+
    "\10\4\3\0\3\4\11\0\1\4\1\115\4\4\7\0"+
    "\13\4\1\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[1833];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\6\1\3\11\1\1\2\11\5\1\6\11"+
    "\10\1\3\11\5\1\1\11\12\1\1\0\30\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[77];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public Lexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzPushbackPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead < 0) {
      return true;
    }
    else {
      zzEndRead+= numRead;
      return false;
    }
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = zzPushbackPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Token yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = zzLexicalState;


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 5: 
          { return new Token(TokenType.MENOR_QUE);
          }
        case 39: break;
        case 6: 
          { return new Token(TokenType.MAIOR_QUE);
          }
        case 40: break;
        case 22: 
          { return new Token(TokenType.MAIOR_IGUAL);
          }
        case 41: break;
        case 10: 
          { return new Token(TokenType.VEZES);
          }
        case 42: break;
        case 16: 
          { return new Token(TokenType.PT_VIRG);
          }
        case 43: break;
        case 33: 
          { return new Token(TokenType.VOID);
          }
        case 44: break;
        case 31: 
          { return new Token(TokenType.ELSE);
          }
        case 45: break;
        case 13: 
          { return new Token(TokenType.FECHA_PAR);
          }
        case 46: break;
        case 29: 
          { return new Token(TokenType.INT);
          }
        case 47: break;
        case 12: 
          { return new Token(TokenType.MODULO);
          }
        case 48: break;
        case 1: 
          { // Casa com qualquer caracter que n�o casar com as expressoes anteriores.
    System.out.println("Illegal character : " + yytext());
	System.out.println("Line: " + yyline);
	System.out.println("Column: " + yycolumn);
          }
        case 49: break;
        case 28: 
          { return new Token(TokenType.NOT);
          }
        case 50: break;
        case 27: 
          { return new Token(TokenType.AND);
          }
        case 51: break;
        case 32: 
          { return new Token(TokenType.CHAR);
          }
        case 52: break;
        case 21: 
          { return new Token(TokenType.MENOR_IGUAL);
          }
        case 53: break;
        case 34: 
          { return new Token(TokenType.PRNT);
          }
        case 54: break;
        case 9: 
          { return new Token(TokenType.MENOS);
          }
        case 55: break;
        case 3: 
          { return new Token(TokenType.IDENTIFICADOR, yytext());
          }
        case 56: break;
        case 38: 
          { return new Token(TokenType.RETURN);
          }
        case 57: break;
        case 7: 
          { return new Token(TokenType.IGUAL);
          }
        case 58: break;
        case 8: 
          { return new Token(TokenType.MAIS);
          }
        case 59: break;
        case 25: 
          { return new Token(TokenType.ATRIBUICAO);
          }
        case 60: break;
        case 30: 
          { return new Token(TokenType.VAR);
          }
        case 61: break;
        case 19: 
          { return new Token(TokenType.FLOAT_LITERAL, yytext());
          }
        case 62: break;
        case 20: 
          { return new Token(TokenType.DIFERENTE);
          }
        case 63: break;
        case 11: 
          { return new Token(TokenType.DIVISAO);
          }
        case 64: break;
        case 37: 
          { return new Token(TokenType.WHILE);
          }
        case 65: break;
        case 4: 
          { return new Token(TokenType.INT_LITERAL, yytext());
          }
        case 66: break;
        case 14: 
          { return new Token(TokenType.ABRE_PAR);
          }
        case 67: break;
        case 23: 
          { return new Token(TokenType.COMENT);
          }
        case 68: break;
        case 35: 
          { return new Token(TokenType.PROC);
          }
        case 69: break;
        case 2: 
          { // Caracteres ignorados.
	// Nenhum token � retornado.
          }
        case 70: break;
        case 26: 
          { return new Token(TokenType.IF);
          }
        case 71: break;
        case 17: 
          { return new Token(TokenType.ABRE_CHAVES);
          }
        case 72: break;
        case 36: 
          { return new Token(TokenType.FLOAT);
          }
        case 73: break;
        case 18: 
          { return new Token(TokenType.FECHA_CHAVES);
          }
        case 74: break;
        case 24: 
          { return new Token(TokenType.OR);
          }
        case 75: break;
        case 15: 
          { return new Token(TokenType.VIRGULA);
          }
        case 76: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
              {
                // Casa com o fim do arquivo apenas.
	return new Token(TokenType.EOF);
              }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
