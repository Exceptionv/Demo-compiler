

���ܹ�ʶ��Ĵʷ������ʾ

���ʷ���	������	���������Ƿ�	����ֵ
begin		1			BEGIN	
end		2			END	
if		3			IF	
then		4			THEN	
else		5			ELSE	
��ʶ��		6			ID	��ĸ��ͷ����ĸ���ִ�
�޷��ų���	7			UCON	���ڶ����Ʊ�ʾ
<		8			LT	
<=		9			LE	
=		10			EQ	
<>		11			NE	
>		12			GT	
>=		13			GE	
:=		14			IS	
+		15			PL	
-		16			MI	
*		17			MU	
/		18			DI	






�ܹ�ʶ����﷨
G2[E]��E �� T | E+T | E-T   T �� F | T*F | T/F   F �� i | (E)
�������SLR1���������������SLR1�ķ�����

״̬					ACTION				      GOTO
	��	��	+	-	*	/	i	#	E	T	F
0	S4						S5		1	2	3
1			S6	S7				Acc			
2		R3	R3	R3	S8	S9		R3			
3		R6	R6	R6	R6	R6		R6			
4	S4						S5		10	2	3
5		R8	R8	R8	R8	R8		R8			
6	S4						S5			11	3
7	S4						S5			12	3
8	S4						S5				13
9	S4						S5				14
10		S15	S6	S7							
11		R1	R1	R1	S8	S9		R1			
12		R2	R2	R2	S8	S9		R2			
13		R4	R4	R4	R4	R4		R4			
14		R5	R5	R5	R5	R5		R5			
15		R7	R7	R7	R7	R7		R7			
