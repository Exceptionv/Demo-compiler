//语法分析程序Gram_test,使用SLR1方法对词法解析出的Lex_class文件进行语法分析

package Mypackage;
import java.util.*;
import Mypackage.Gram_mean;

public class Gram_code
{
   Stack state=new Stack(); //SLR1分析所需要的状态栈
   private String sentance;//从上层程序Gram_Read中返回的句子
   private int row;//从上层程序Gram_Read中返回的当前所读行数，用于报错
    int i=0; //i记录当前分析到句子的第几个字符

   private Gram_mean m=new Gram_mean();//语义分析接口

	public Gram_code(String s,int row)
	{
		    sentance=s;
        this.row=row;
        state.push(0);
    }

    public void Core()
    {
        while(Integer.parseInt(state.peek().toString())!=100) //终止条件：当栈顶出现100时，即规约成功或者规约失败程序结束

        {
        	if(i>=sentance.length())
        		{i=sentance.length()-1;}  //对句子分析进行到句末时，并不跳出

          char t;//t用于记录下一步状态对应的状态是E,A,R,S中的哪一个
        	char tem[]= new char[2];  //临时记录查询P表的结果


        	//符号串中当前指向，状态栈中当前状态
        	SLR1 c=new SLR1(sentance.charAt(i),Integer.parseInt(state.peek().toString()));

        	System.out.println("sentance.charAt(i)"+sentance.charAt(i));

        	//查Action表返回下一步状态
        	t=c.SearchA();

        	System.out.println("this is "+t);

        	if(t=='E')
        	{
             state.push(100);//栈顶压入100，语法分析结束。
             GramE e=new GramE(row);
             e.output();//报错
        		 System.out.println("Error!");
          }

            if(t=='A')
            {
              m.print();//打印语义分析中所有产生式
              state.push(100);//栈顶压入100,语法分析结束。
              GramA a=new GramA(row);
              a.output();//接受
            	System.out.println("Accept!");
            }

            if(t=='S')
            {
              state.push(c.SearchG());
            	System.out.println("top is:"+state.peek().toString());
            }


            if(t=='R')
            {
               m.access(c.SearchG());//进行语义分析

               tem=c.SearchP(c.SearchG());//查产生式表
               for(int k=0;k<tem[1]-'0';k++)//出栈
               {state.pop();}


               SLR1 a=new SLR1(tem[0],Integer.parseInt(state.peek().toString()));//以新状态查Action表

               System.out.println("a.SearchG()="+a.SearchG());
               state.push(a.SearchG());//找到下一状态；
               i--;//字符回退
            }
            i++;
        }
    }


}
