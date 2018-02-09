# Demo-compiler
这是一个由java语言实现的简单文法编译器

所能够识别的词法如表所示  
单词符号	类别编码	类别码的助记符   	单词值
begin     	1       	BEGIN	
end	        2          END	
if	        3	          IF	
then      	4	         THEN	
else	      5	         ELSE	
标识符	      6 	       ID	       字母打头的字母数字串
无符号常数  	7	         UCON	      机内二进制表示
         	8	          LT	
=        	9         	LE	
=         	10	        EQ	
	        11        	NE	
         	12	        GT	
=        	13        	GE	
=	        14        	IS	
+	          15	        PL	
-	          16	        MI	
	          17	        MU	
         	18        	DI	

能够识别的语法
G2[E]：E → T  E+T  E-T   T → F  TF  TF   F → i  (E)

程序采用SLR1分析法，下面给出SLR1的分析表以及对应的初始化程序

状
态        	ACTION                                         	GOTO
	   （    	）    +	    -	     	    	     i    	#   	E   	 T   	  F
0	    S4						                          S5	          1	    2      3
1		         	 S6	   S7				                       Acc			
2		        R3	  R3	    R3	  S8	   S9		         R3			
3		        R6	  R6	    R6	  R6	   R6		         R6			
4	    S4						                          S5		        10    2      3
5		        R8	  R8	    R8	  R8	   R8		         R8			
6	    S4						                          S5			            11	   3
7	    S4					                            S5			            12	   3
8	    S4						                          S5				                 13
9	    S4						                          S5			                   14
10		     S15	  S6	   S7							
11	      	R1	  R1     R1	    S8	   S9		         R1			
12		      R2	  R2	   R2	    S8	   S9		         R2			
13		      R4	  R4	   R4	    R4	   R4		         R4			
14		      R5	  R5	   R5	    R5	   R5		         R5			
15		      R7	  R7	   R7	    R7	   R7		         R7			





程序由三个模块组成：
1.输入模块：
在test.txt（Cjava）中输入要分析的内容。

2.分析模块：
由词法分析部分Identi和语法及语义分析部分Gram组成，它们被封装在Mypackage文件夹中（CMypackage）。
模块的入口程序是Lex_Read.java和Gram_Read.java。只需顺序运行这个两个程序，即可进入分析模块，本模块将对test.text中的内容进行分析，分析结果转交输出模块。

3.输出模块：
由Lex_Userface.txt，Lex_value.txt，Lex_class.txt和Middle_code.txt （Cjava）组成。
其中，Lex_Userface.txt中存放的是分析模块中的报错信息，包括词法报错和语法报错。Lex_value.txt和Lex_class.txt中存放的是词法分析结束后每个单词对应的value和class值。Middle_code.txt存放的是语义分析后生成的中间代码。
