import java.io.*;
import java.util.*;

class Finalize_ex
{
	
   public void finalize()
   {

     System.out.println("finalize method is called");
   }

}
class Demo_finals
{
	
  public static void main(String[] args)
  {
     Finalize_ex f1=new Finalize_ex();
     Finalize_ex f2=new Finalize_ex();
     f1=null;
     f2=null;
     System.gc();
      final int x=20;

      try{

        int y=30;
      }
      catch(Exception e){
        System.out.println(e);
      }
      finally{
          
           System.out.println("Finally block");
      }

 

  }





}