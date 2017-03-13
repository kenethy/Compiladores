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

	return
.end method

.method public <init>()V
	aload_0
	invokenonvirtual java/lang/Object/<init>()V
	return
.end method

