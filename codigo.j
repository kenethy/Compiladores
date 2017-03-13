.class public Codigo
.super java/lang/Object


.method public static main([Ljava/lang/String;)V
	.limit locals 10
	.limit stack 10

	ldc 51423
	istore_0

	iload_0
	ldc 2
	idiv
	ldc 2
	imul
	istore_1

	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 79
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 32
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 56
	invokevirtual java/io/PrintStream/print(I)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 32
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 16.7
	invokevirtual java/io/PrintStream/print(F)V

	iload_0
	iload_1
	if_icmpeq equal0
	iconst_0
	goto depoisE0
equal0:
 	iconst_1
depoisE0:

	return
.end method

.method public <init>()V
	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return
.end method

