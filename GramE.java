//识别错误
//子程序GramE希望能够向用户视图Lex_Userface.txt中写入ERROR



package Mypackage;
import java.util.*;
import java.io.File;
import java.io.FileWriter;

public class GramE
{
    private int row;
    public GramE(int row)
    {
      this.row=row;
    }

    public void output()
	  {
	    File file2 = new File("c:/java/Lex_Userface.txt");
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

            String str = new String("Gram Error! at"+row+"\r\n");
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
