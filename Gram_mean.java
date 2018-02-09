//整个语法分析程序由 语法辅助分析栈mean 和 语义表v 组成
package Mypackage;
import java.util.*;
import java.io.File;
import java.io.FileWriter;

public class Gram_mean
{
  Stack mean=new Stack();//语法辅助分析栈，其中记录要回填的三元式的索引号
  private int gram; //表示当前采用的是第几号产生式对应的语义
  private Vector v = new Vector();//记录三元式
  private int index; //三元式对应的索引号

  public void access(int g)
  {

    gram=g;

    switch(gram)
    {
      case 1:
       {
         //一号产生式的语义分析动作
        //从辅助分析栈mean中弹出两个索引号，以这两个索引号作为操作数填入三元式表v，对应的操作符是“+”
        v.add("{"+"+"+","+mean.pop()+","+mean.pop()+"}");
        //获得当前三元式序号，此序号入栈
        index=v.size();
        mean.push(index);
      }
      break;

      case 2:
       {
         //二号产生式的语义分析动作
        //从辅助分析栈mean中弹出两个索引号，以这两个索引号作为操作数填入三元式表v，对应的操作符是“-”
        v.add("{"+"-"+","+mean.pop()+","+mean.pop()+"}");
        //获得当前三元式序号，此序号入栈
        index=v.size();
        mean.push(index);
      }
      break;

      case 3:
       {
         //三号产生式的语义分析动作
        //从辅助分析栈mean中弹出一个索引号，以这一个索引号和中间状态"E"作为操作数填入三元式表v，对应的操作符是“=”
        v.add("{"+"="+","+"E"+","+mean.pop()+"}");
        //获得当前三元式序号，此序号入栈
        index=v.size();
        mean.push(index);
      }
      break;

      case 4:
       {
         //四号产生式的语义分析动作
        //从辅助分析栈mean中弹出两个索引号，以这两个索引号作为操作数填入三元式表v，对应的操作符是“*”
        v.add("{"+"*"+","+mean.pop()+","+mean.pop()+"}");
        //获得当前三元式序号，此序号入栈
        index=v.size();
        mean.push(index);
      }
      break;

      case 5:
       {
         //五号产生式的语义分析动作
        //从辅助分析栈mean中弹出两个索引号，以这两个索引号作为操作数填入三元式表v，对应的操作符是“/”
        v.add("{"+"/"+","+mean.pop()+","+mean.pop()+"}");
        //获得当前三元式序号，此序号入栈
        index=v.size();
        mean.push(index);
      }
      break;

      case 6:
       {
         //六号产生式的语义分析动作
        //从辅助分析栈mean中弹出一个索引号，以这一个索引号和中间状态“T”作为操作数填入三元式表v，对应的操作符是“=”
        v.add("{"+"="+","+"T"+","+mean.pop()+"}");
        //获得当前三元式序号，此序号入栈
        index=v.size();
        mean.push(index);
      }
      break;

      case 7:
       {
         //七号产生式的语义分析动作
        //从辅助分析栈mean中弹出一个索引号，以这一个索引号和中间状态“F”作为操作数填入三元式表v，对应的操作符是“=”
        v.add("{"+"="+","+"F"+","+mean.pop()+"}");
        //获得当前三元式序号，此序号入栈
        index=v.size();
        mean.push(index);
      }
      break;

      case 8:
       {
         //八号产生式的语义分析动作
        //以当前i.val和中间状态“F”作为操作数填入三元式表v，对应的操作符是“=”
        v.add("{"+"="+","+"F"+","+"i"+"}");
        //获得当前三元式序号，此序号入栈
        index=v.size();
        mean.push(index);
      }
      break;


    }


  }

  public void print()
  {

    File file2 = new File("c:/java/Middle_code.txt");
    if (file2.exists()) {  }
    else
    {
        try
        {
            file2.createNewFile();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }



     try
     {
          FileWriter fileWriter = new FileWriter(file2,true);

          for(int i = 0;i < v.size();i++)
          {
            fileWriter.write(v.get(i)+"\r\n");
          }
          fileWriter.close();

     }

      catch (Exception e)
      {
       e.printStackTrace();
      }

  }
}
