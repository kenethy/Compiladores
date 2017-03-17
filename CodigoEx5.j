.class public Codigo
.super java/lang/Object



.method public static raizDe(F)F
	.limit locals 10
	.limit stack 10

	ldc 0
	istore 1

	fload 0
	fstore 2

while0:
	iload 1
	ldc 10
	if_icmplt less0
	iconst_0
	goto depoisL0
less0:
 	iconst_1
depoisL0:

	ifeq done0
	fload 2
	ldc 2.0
	fdiv
	fload 0
	ldc 2.0
	fload 2
	fmul
	fdiv
	fadd
	fstore 2

	iload 1
	ldc 1
	iadd
	istore 1

	goto while0
done0:
	fload 2
	freturn
.end method


.method public static calculoX1(FFFF)F
	.limit locals 10
	.limit stack 10

	fload 3
	invokestatic Codigo/raizDe(F)F
	fstore 5

	ldc 2.0
	fload 0
	fmul
	fstore 6

	fload 1
	fneg
	fload 5
	fadd
	fstore 4

	fload 4
	fload 6
	fdiv
	fstore 4

	fload 4
	freturn
.end method


.method public static calculoX2(FFFF)F
	.limit locals 10
	.limit stack 10

	fload 3
	invokestatic Codigo/raizDe(F)F
	fstore 5

	ldc 2.0
	fload 0
	fmul
	fstore 6

	fload 1
	fneg
	fload 5
	fadd
	fstore 4

	fload 4
	fload 6
	fdiv
	fstore 4

	fload 4
	freturn
.end method


.method public static calcDelta(FFF)F
	.limit locals 10
	.limit stack 10

	fload 1
	fload 1
	fmul
	fstore 3

	ldc 4.0
	fload 0
	fmul
	fload 2
	fmul
	fstore 4

	fload 3
	fload 4
	fsub
	fstore 3

	fload 3
	freturn
.end method


.method public static main([Ljava/lang/String;)V
	.limit locals 10
	.limit stack 10

	ldc 1.0
	fstore 0

	ldc 1.0
	fstore 1

	ldc 2.0
	fneg
	fstore 2

	fload 0
	fload 1
	fload 2
	invokestatic Codigo/calcDelta(FFF)F
	fstore 3

	fload 3
	ldc 0.0
	fcmpg
	iflt less1
	iconst_0
	goto depoisL1
less1:
 	iconst_1
depoisL1:

comandoIf1:
	ifeq comandoElse1
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 68
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 69
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 76
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 84
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 65
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 32
	invokevirtual java/io/PrintStream/print(C)V

	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 78
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 69
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 71
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 65
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 84
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 73
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 86
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 79
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 10
	invokevirtual java/io/PrintStream/print(C)V

	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 78
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 65
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 79
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 32
	invokevirtual java/io/PrintStream/print(C)V

	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 69
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 88
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 73
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 83
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 84
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 69
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 32
	invokevirtual java/io/PrintStream/print(C)V

	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 82
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 65
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 73
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 90
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 69
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 83
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 10
	invokevirtual java/io/PrintStream/print(C)V

	goto pularElse1
comandoElse1:
	fload 0
	fload 1
	fload 2
	fload 3
	invokestatic Codigo/calculoX1(FFFF)F
	fstore 3

	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 88
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 49
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 58
	invokevirtual java/io/PrintStream/print(C)V

	getstatic java/lang/System/out Ljava/io/PrintStream;
	fload 3
	invokevirtual java/io/PrintStream/print(F)V

	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 10
	invokevirtual java/io/PrintStream/print(C)V

	fload 0
	fload 1
	fload 2
	fload 3
	invokestatic Codigo/calculoX2(FFFF)F
	fstore 3

	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 88
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 50
	invokevirtual java/io/PrintStream/print(C)V
	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 58
	invokevirtual java/io/PrintStream/print(C)V

	getstatic java/lang/System/out Ljava/io/PrintStream;
	fload 3
	invokevirtual java/io/PrintStream/print(F)V

	getstatic java/lang/System/out Ljava/io/PrintStream;
	ldc 10
	invokevirtual java/io/PrintStream/print(C)V

pularElse1:
	return
.end method

.method public <init>()V
	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return
.end method

