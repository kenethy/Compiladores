.class public Codigo
.super java/lang/Object



.method public static mdcDe$e(II)I
	.limit locals 10
	.limit stack 10

	iload 1
	ldc 0
	if_icmpeq equal0
	iconst_0
	goto depoisE0
equal0:
 	iconst_1
depoisE0:

comandoIf1:
	ifeq comandoElse1
	iload 0
	ireturn
comandoElse1:
	iload 1
	iload 0
	iload 1
	irem
	invokestatic Codigo/mdcDe$e(II)I
	ireturn
.end method


.method public static main([Ljava/lang/String;)V
	.limit locals 10
	.limit stack 10

	ldc 120
	istore 0

	ldc 640
	istore 1

	iload 0
	iload 1
	invokestatic Codigo/mdcDe$e(II)I
	istore 2

	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 109
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 100
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 99
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 40
	invokevirtual java/io/PrintStream/print(C)V

	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 0
	invokevirtual java/io/PrintStream/print(I)V

	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 44
	invokevirtual java/io/PrintStream/print(C)V

	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 1
	invokevirtual java/io/PrintStream/print(I)V

	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 41
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 58
	invokevirtual java/io/PrintStream/print(C)V

	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 2
	invokevirtual java/io/PrintStream/print(I)V

	return
.end method

.method public <init>()V
	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return
.end method

