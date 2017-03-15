.class public Codigo
.super java/lang/Object

.field private static n I 
.field private static soma I 

.method public static soma$primeirosImpares(I)I
	.limit locals 10
	.limit stack 10

	ldc 0
	istore_3

	ldc 0
	istore_1

while0:
	iload_1
	iload_0
	if_icmplt less0
	iconst_0
	goto depoisL0
less0:
 	iconst_1
depoisL0:

	ifeq done0
	ldc 2
	iload_1
	imul
	ldc 1
	iadd
	istore_2

	iload_3
	iload_2
	iadd
	istore_3

	iload_1
	ldc 1
	iadd
	istore_1

	goto while0
done0:
	iload_3
	ireturn
.end method

.method public static main([Ljava/lang/String;)V
	.limit locals 10
	.limit stack 10

	ldc 9
	invokestatic Codigo/soma$primeirosImpares(I)I
	istore_0

	getstatic java/lang/System/out Ljava/io/PrintStream;
	iload_0
	invokevirtual java/io/PrintStream/print(I)V

	return
.end method

.method public <init>()V
	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return
.end method

