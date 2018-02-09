package Mypackage;
import java.util.*;
import java.io.File;
import java.io.FileWriter;

public class LEX_END
{
    private int row;
    public LEX_END(int row)
    {
      this.row=row;
    }

    public void output()
	  {
	    File file1 = new File("c:/java/Lex_Userface.txt");


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



      try
      {
            FileWriter fileWriter1 = new FileWriter(file1,true);
            String str1 = new String("Lex end! at"+row+"\r\n");


            FileWriter fileWriter2 = new FileWriter(file2,true);
            String str2= new String(";"+"\r\n");


            System.out.println(str1);
            fileWriter1.write(str1);
            fileWriter1.close();

            fileWriter2.write(str2);
            fileWriter2.close();



        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
    }
}
