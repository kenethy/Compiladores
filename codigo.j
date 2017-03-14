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

	ldc 2
	ldc 2
	if_icmpgt greater0
	iconst_0
	goto depoisG0
greater0:
 	iconst_1
depoisG0:

	ldc 1
	ldc 1
	if_icmpeq equal1
	iconst_0
	goto depoisE1
equal1:
 	iconst_1
depoisE1:

	ifeq pTrue0
	iconst_0
	goto jumpPTrue0
pTrue0:
	iconst_1
jumpPTrue0:
	ior
comandoIf0:
	ifeq comandoElse0
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 49
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 110
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 10
	invokevirtual java/io/PrintStream/print(C)V

	goto pularElse0
comandoElse0:
pularElse0:
	iload_0
	iload_1
	if_icmpeq equal2
	iconst_0
	goto depoisE2
equal2:
 	iconst_1
depoisE2:

	ifeq pTrue1
	iconst_0
	goto jumpPTrue1
pTrue1:
	iconst_1
jumpPTrue1:
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

