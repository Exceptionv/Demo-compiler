# Demo-compiler
这是一个由java语言实现的简单文法编译器

程序由三个模块组成：
1.输入模块：
在test.txt（Cjava）中输入要分析的内容。

2.分析模块：
由词法分析部分Identi和语法及语义分析部分Gram组成，它们被封装在Mypackage文件夹中（CMypackage）。
模块的入口程序是Lex_Read.java和Gram_Read.java。只需顺序运行这个两个程序，即可进入分析模块，本模块将对test.text中的内容进行分析，分析结果转交输出模块。

3.输出模块：
由Lex_Userface.txt，Lex_value.txt，Lex_class.txt和Middle_code.txt （Cjava）组成。
其中，Lex_Userface.txt中存放的是分析模块中的报错信息，包括词法报错和语法报错。Lex_value.txt和Lex_class.txt中存放的是词法分析结束后每个单词对应的value和class值。Middle_code.txt存放的是语义分析后生成的中间代码。
