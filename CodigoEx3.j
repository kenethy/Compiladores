.class public Codigo
.super java/lang/Object



.method public static main([Ljava/lang/String;)V
	.limit locals 10
	.limit stack 10

	ldc 51423
	istore 0

	iload 0
	ldc 2
	idiv
	ldc 2
	imul
	istore 1

	iload 0
	iload 1
	if_icmpeq equal0
	iconst_0
	goto depoisE0
equal0:
 	iconst_1
depoisE0:

comandoIf1:
	ifeq comandoElse1
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 80
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 65
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 82
	invokevirtual java/io/PrintStream/print(C)V

	goto pularElse1
comandoElse1:
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 73
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 77
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 80
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 65
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 82
	invokevirtual java/io/PrintStream/print(C)V

pularElse1:
	return
.end method

.method public <init>()V
	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return
.end method

