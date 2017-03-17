.class public Codigo
.super java/lang/Object



.method public static buscaRaizDe$entre$e(FFF)F
	.limit locals 10
	.limit stack 10

	fload 1
	fload 2
	fadd
	ldc 2.0
	fdiv
	fstore 4

	fload 4
	fload 4
	fmul
	fload 0
	fsub
	fstore 3

	fload 3
	ldc 1.0E-4
	fneg
	fcmpg
	ifge greaterEQ0
	iconst_0
	goto depoisGE0
greaterEQ0:
 	iconst_1
depoisGE0:

	fload 3
	ldc 1.0E-4
	fcmpg
	ifle lessEq1
	iconst_0
	goto depoisLE1
lessEq1:
 	iconst_1
depoisLE1:

	iand
comandoIf1:
	ifeq comandoElse1
	fload 4
	freturn
comandoElse1:
	fload 3
	ldc 0.0
	fcmpg
	iflt less2
	iconst_0
	goto depoisL2
less2:
 	iconst_1
depoisL2:

comandoIf2:
	ifeq comandoElse2
	fload 0
	fload 4
	fload 2
	invokestatic Codigo/buscaRaizDe$entre$e(FFF)F
	freturn
comandoElse2:
	fload 0
	fload 1
	fload 4
	invokestatic Codigo/buscaRaizDe$entre$e(FFF)F
	freturn
.end method


.method public static raizDe(F)F
	.limit locals 10
	.limit stack 10

	fload 0
	ldc 0.0
	fcmpg
	ifeq equal3
	iconst_0
	goto depoisE3
equal3:
 	iconst_1
depoisE3:

	fload 0
	ldc 1.0
	fcmpg
	ifeq equal4
	iconst_0
	goto depoisE4
equal4:
 	iconst_1
depoisE4:

	ior
comandoIf5:
	ifeq comandoElse5
	fload 0
	freturn
comandoElse5:
	fload 0
	ldc 0.0
	fload 0
	invokestatic Codigo/buscaRaizDe$entre$e(FFF)F
	freturn
.end method


.method public static main([Ljava/lang/String;)V
	.limit locals 10
	.limit stack 10

	ldc 0.0
	fstore 0

while0:
	fload 0
	ldc 10.0
	fcmpg
	ifle lessEq5
	iconst_0
	goto depoisLE5
lessEq5:
 	iconst_1
depoisLE5:

	ifeq done0
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 114
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 97
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 105
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 122
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 32
	invokevirtual java/io/PrintStream/print(C)V

	getstatic java/lang/System/out Ljava/io/PrintStream;
	fload 0
	invokevirtual java/io/PrintStream/print(F)V

	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 32
	invokevirtual java/io/PrintStream/print(C)V

	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 58
	invokevirtual java/io/PrintStream/print(C)V

	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 32
	invokevirtual java/io/PrintStream/print(C)V

	getstatic java/lang/System/out Ljava/io/PrintStream;
	fload 0
	invokestatic Codigo/raizDe(F)F
	invokevirtual java/io/PrintStream/print(F)V

	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 10
	invokevirtual java/io/PrintStream/print(C)V

	fload 0
	ldc 1.0
	fadd
	fstore 0

	goto while0
done0:
	return
.end method

.method public <init>()V
	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return
.end method

