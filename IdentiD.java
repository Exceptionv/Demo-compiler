//无符号数识别
package Mypackage;
import java.io.File;
import java.io.FileWriter;
import java.lang.Math;

public class IdentiD
{

	  final int DIGIT=1;
    final int POINT=2;
    final int POWER=4;
    final int PLUS=5;
    final int MINUS=6;
    final int UCON=7;
    final int EndState=-1;
    final int OTHER=3;

	private int w=0;
	private int d=0;
	private int n=0;
	private int p=0;
	private int e=1;
	private int CurrentState=0;



    private String s;
    private int c;
    private double V=0.0;

    private int j=0;

	public IdentiD(String str)
	{
		s=str;
	}

	public int GetChar()
	{


		char c=s.charAt(j);
		j++;
		if(c>='0'&&c<='9')
			{
				d=c-'0';
				return DIGIT;
			}
		if(c=='.')
			return POINT;
		if(c=='E'||c=='e')
			return POWER;
		if(c=='+')
			return PLUS;
		if(c=='-')
			return 	MINUS;
		if(c=='#')
		{
			CurrentState=EndState;
			return EndState;
		}



		return OTHER;

	}


	public int EXCUTE(int state,int symbol)
	{
		switch (state)
		{
			case -1:break;

			case 0: switch(symbol)
			{
				case DIGIT:n=0;p=0;e=1;w=d;CurrentState=1;c=UCON;break;
				case POINT:w=0;n=0;p=0;e=1;CurrentState=3;c=UCON;break;
				default:CurrentState=EndState;c=OTHER;
			}
			break;

			case 1:switch(symbol)
			{
				case DIGIT:w=w*10+d;c=UCON;break;
				case POINT:CurrentState=2;c=UCON;break;
				case POWER:CurrentState=4;c=UCON;break;
				default:CurrentState=EndState;c=OTHER;
			}
			break;

			case 2:switch(symbol)
			{
				case DIGIT:n++;w=w*10+d;c=UCON;break;
				case POWER:CurrentState=4;c=UCON;break;
				default:CurrentState=EndState;c=OTHER;
			}
			break;

			case 3:switch(symbol)
			{
				case DIGIT:n++;w=w*10+d;CurrentState=2;c=UCON;break;
				default:CurrentState=EndState;c=OTHER;
			}
			break;

			case 4:switch(symbol)
			{
				case DIGIT:p=p*10+d;CurrentState=6;c=UCON;break;
				case MINUS:e=-1;CurrentState=5;c=UCON;break;
				case PLUS:CurrentState=5;c=UCON;break;
				default:CurrentState=EndState;c=OTHER;
			}
			break;

			case 5:switch(symbol)
			{
				case DIGIT:p=p*10+d;CurrentState=6;c=UCON;break;
				default:CurrentState=EndState;c=OTHER;
			}
			break;

			case 6:switch(symbol)
			{
				case DIGIT:p=p*10+d;c=UCON;break;
				default:CurrentState=EndState;c=OTHER;
			}
			break;


		}
		return CurrentState;
    }

	public void LEX()
	{


	   int ch=0;
	   while(CurrentState!=EndState)
	   {
	   	 ch=GetChar();

	   	 EXCUTE(CurrentState,ch);

	   }
	   V=w*Math.pow(10,e*p-n);

    }


	  public boolean Verdict()
		{
			if(c==7)
			{return true;}

			if(c==3)
			{return false;}

			return false;
		}



    public void output()
	  {
			  File file1 = new File("c:/java/Lex_value.txt");
	      File file2 = new File("c:/java/Lex_class.txt");

        if (file1.exists()) {  }
				else
				{
            try
						{
                file1.createNewFile();
            }
						catch (Exception e)
						{
                 e.printStackTrace();
            }
        }

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
			      	FileWriter fileWriter1 = new FileWriter(file1,true);
              FileWriter fileWriter2 = new FileWriter(file2,true);

            	String cl="i";
            	String va=String.valueOf(V);

            	String str2=cl;
            	System.out.println(str2);
              fileWriter2.write(str2);

							String str1=va;
            	System.out.println(str1);
              fileWriter1.write(str1+"\r\n");

							fileWriter1.close();
							fileWriter2.close();

    }

	   catch (Exception e)
		  {
           e.printStackTrace();
      }
    }

}
