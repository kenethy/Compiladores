
.class public TestPrint
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
       ; set limits used by this method
       .limit locals 4
       .limit stack 3

       ; var #1 - the PrintStream object held in java.lang.System.out
       getstatic java/lang/System/out Ljava/io/PrintStream;
       astore_1 ;carrega o topo da pilha de operandos(pop) na posição 1 do array de var. local
	   
       ; print a string
       aload_1           ; push the PrintStream object /// carrega oq tem na posição 1 do array de locais, no topo da pilha de operandos (push)
       ldc "c" ; push the parameter (it comes from constant pool, in this case)
       invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

       ; print an int
       aload_1   ; push the PrintStream object
       ;ldc 65 ; push the parameter
	   ldc "c"
	   astore_2
	   aload_2
       invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

       ; done
       return

.end method


; standard initializer (constuctor)
.method public <init>()V
   aload_0
   invokenonvirtual java/lang/Object/<init>()V
   return
.end method