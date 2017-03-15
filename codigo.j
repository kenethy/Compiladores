.class public Codigo
.super java/lang/Object


.method public static mdcDe$e(II)I
	.limit locals 10
	.limit stack 10

	iload_1
	ldc 0
	if_icmpeq equal0
	iconst_0
	goto depoisE0
equal0:
 	iconst_1
depoisE0:

comandoIf0:
	ifeq comandoElse0
	iload_0
	ireturn
comandoElse0:
	iload_1
	iload_0
	iload_1
	irem
	invokestatic Codigo/mdcDe$e(II)I
	ireturn
.end method

.method public static main([Ljava/lang/String;)V
	.limit locals 10
	.limit stack 10

	ldc 15
	istore_0

	ldc 5
	istore_1

	iload_0
	iload_1
	invokestatic Codigo/mdcDe$e(II)I
	istore_2

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
	iload_0
	invokevirtual java/io/PrintStream/print(I)V

	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 44
	invokevirtual java/io/PrintStream/print(C)V

	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload_1
	invokevirtual java/io/PrintStream/print(I)V

	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 41
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 58
	invokevirtual java/io/PrintStream/print(C)V

	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload_2
	invokevirtual java/io/PrintStream/print(I)V

	return
.end method

.method public <init>()V
	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return
.end method

