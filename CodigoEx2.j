.class public Codigo
.super java/lang/Object

.field private static n I 
.field private static soma I 


.method public static soma$primeirosImpares(I)I
	.limit locals 10
	.limit stack 10

	ldc 0
	istore 3

	ldc 0
	istore 1

while0:
	iload 1
	iload 0
	if_icmplt less0
	iconst_0
	goto depoisL0
less0:
 	iconst_1
depoisL0:

	ifeq done0
	ldc 2
	iload 1
	imul
	ldc 1
	iadd
	istore 2

	iload 3
	iload 2
	iadd
	istore 3

	iload 1
	ldc 1
	iadd
	istore 1

	goto while0
done0:
	iload 3
	ireturn
.end method


.method public static main([Ljava/lang/String;)V
	.limit locals 10
	.limit stack 10

	ldc 9
	invokestatic Codigo/soma$primeirosImpares(I)I
	istore 0

	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload 0
	invokevirtual java/io/PrintStream/print(I)V

	return
.end method

.method public <init>()V
	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return
.end method

