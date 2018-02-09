package Mypackage;
//java 词法分析子程序DemoScanner
//由Scanner（扫描器） 和Morphylogy（词法分析）两个部分组成
//MainScanner类主要完成：从上层的read方法中读入的一行字符串，对这个字符串进行扫描
//扫描决定要当前读入的是字符，数字，空格，etc.对不同读入转到不同的子程序进行处理。
import Mypackage.IdentiD;
import Mypackage.IdentiE;
import Mypackage.IdentiA;
import Mypackage.IdentiM;
import Mypackage.LEX_END;

public class MainScanner
{
	final int DIGIT=1; //1号状态,表示扫描到数字，对应IdentiD子程序
	final int APH=2;  //2号状态，表示扫描到标识符，对应IdentiA子程序
	final int SPECIAL=3;//3号状态,表示扫描到关键字，对应IdentiM子程序
	final int BLANK=4;//4号状态,表示扫描到空格，跳过
	final int END=5;//5号状态,表示扫描到终止符 “；”，程序正常出口
	final int ERROR=6;//6号状态,表示扫描到不合理词法，对应IdentiE子程序，程序非正常出口


	private String s; //上层程序接口，句子s
	private int row;//上层程序接口，当前行数row

	private String s1;//下层程序接口，单词s1
	private int j=0; //当前读入到第几个字符
  private int i;
  private char c;//暂存当前读入的字符

	public MainScanner(String str,int row)
	{
		s=str;
		this.row=row;
	}


	public int GetChar(int j)  //开始扫描，返回状态编号
	{
		char ch=s.charAt(j);
		if(ch>='0'&&ch<='9')return DIGIT;
		if(ch>='a'&&ch<='z')return APH;
		if(ch==' ')return BLANK;
		if(ch==':'||ch=='>'||ch=='<'||ch=='='||ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='('||ch==')')return SPECIAL;
    if(ch==';')return END;

		return ERROR;
	}

	public void Scanner(int t)
	{
		switch (t)
		{
			case BLANK: j++;break;

			case ERROR:

			    IdentiE e=new IdentiE(row);
          e.output();//用户视图写入Error
			    j=s.length(); //程序立马跳出
			    break;

			case END:
			    LEX_END end=new LEX_END(row);
					end.output();
			    j=s.length();
					break;

			case APH:
			    i=j;
			    c=s.charAt(j);

			    while((c>='a'&&c<='z')||(c>='0'&&c<='9'))
			    { j++; c=s.charAt(j); }

			    s1=s.substring(i,j);
			    IdentiA a=new IdentiA(s1);
			    a.Matching();
			    a.output();
			    break;

			case DIGIT:
			    i=j;
			    c=s.charAt(j);
			    while((c>='0'&&c<='9')||(c=='E')||(c=='e')||(c=='.')||(c=='+'&&s.charAt(j-1)=='E')||(c=='+'&&s.charAt(j-1)=='e')||(c=='-'&&s.charAt(j-1)=='E')||(c=='-'&&s.charAt(j-1)=='e'))
			    { j++; c=s.charAt(j);}

			    s1=s.substring(i,j)+"#";
			    IdentiD d=new IdentiD(s1);
			    d.LEX();
			    if(d.Verdict()==false)
				  {
						IdentiE e1=new IdentiE(row);
            e1.output();//用户视图写入Error
			      j=s.length(); //程序立马跳出
					}

					else
					{
						d.output();
					}

					break;


      case SPECIAL:
          i=j;
			    c=s.charAt(j);


				while((c==':')||(c=='>')||(c=='<')||(c=='=')||(c=='+')||(c=='-')||(c=='*')||(c=='/')||(c=='(')||(c==')'))
			    { j++; c=s.charAt(j); }

			    s1=s.substring(i,j);
					System.out.println(s1);
			    IdentiM m=new IdentiM(s1);
			    if(m.Matching()==true)
			    {
						m.output();
					}
          else
					{
						IdentiE e2=new IdentiE(row);
	          e2.output();//用户视图写入Error
				    j=s.length(); //程序立马跳出
					}

       break;
}
		j--;

	}


	public void Morphology()
	{
		while(j<s.length())
		{
		       System.out.println("j="+j);
           int t=GetChar(j);
           System.out.println("t="+t);
           Scanner(t);
           j++;

		}
	}
}
