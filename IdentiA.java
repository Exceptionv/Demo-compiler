//识别是关键字，标识符
package Mypackage;
import java.io.File;
import java.io.FileWriter;
public class IdentiA
{
	private String s;
	private String token[]=new String[]{"begin","end","if","then","else"};
	private int loc=100;
	private String cl;
	private String va;

	public IdentiA(String str)
	{
		s=str;
	}

	public void Matching()
	{
        for(int i=0;i<5;i++)
        {
        	if(s.equals(token[i])==true)
        	{loc=i;}
        }

        if(loc>=0&&loc<=4)
        {
        	cl=token[loc];
        	va=null;
        }
        else
        {
        	cl="i";
        	va=s;
        }
	}

	public void output()
	{


	      File file2 = new File("c:/java/Lex_class.txt");
        if (file2.exists()) {  }
        else {
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
            String str=cl;
            System.out.println(str);
            fileWriter.write(str);
            fileWriter.close();


        }
				catch (Exception e)
				{
          e.printStackTrace();
        }

	}




}
