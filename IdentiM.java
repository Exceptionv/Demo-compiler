package Mypackage;
import java.io.File;
import java.io.FileWriter;
import java.util.*;
public class IdentiM
{
	private String s;
	private String token1[]=new String[]{"<","<=","=","<>",">",">=",":=","+","-","*","/","(",")"};

	private int loc=100;
	private String cl;
	private String va;

	public static void main(String[] args) {}


	public IdentiM(String str)
	{
		s=str;
	}
	public boolean Matching()
	{
		 for(int i=0;i<13;i++)
        {
        	if(s.equals(token1[i])==true)
        	{loc=i;}
        }

        if(loc>=0&&loc<=12)
        {
        	cl=token1[loc];
        	va=null;
					return true;
        }
        else
        {
        	return false;
        }


	}
	public void output()
	{


	      File file2 = new File("c:/java/Lex_class.txt");
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



      try {
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
