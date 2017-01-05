import java.io.*;
import java.util.*;
public class Demo_Exception{  

	void Exception_Fun(int x)
	{
      try{  
    int a[]=new int[5];  
    int div=30/x;  
    System.out.println(div);
    int div=a[5];
    System.out.println(div);
   }  
   catch(ArithmeticException e){
    System.out.println(e);
    }
    catch(ArrayIndexOutOfBoundsException e)
    {

    	 System.out.println(e);
    }
	}
  public static void main(String args[]){ 
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    Demo_Exception d = new Demo_Exception();
    d.Exception_Fun(n); 
         
 }  
}  