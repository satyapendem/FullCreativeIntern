import java.util.*;
class Demo_Exception
{
	
  void Ex1(int a,int b)
  {
    try
    {
       int c = a/b;
       System.out.println(c);

    }
    catch(Exception e){
    	System.out.println("You have Arithematic Exception");
    }

  }
void Ex2()
{
	try{
        int a[]=new int[10];
        a[11] = 9;
      }
      catch(Exception e){
         System.out.println ("ArrayIndexOutOfBounds");
      }
}
void Ex3()
{
	try{
	 int num=Integer.parseInt ("XYZ") ;
	 System.out.println(num);
      }catch(Exception e){
	  System.out.println("Number format exception occurred");
       }
}
void Ex4()
{
	try{
		String str=null;
		System.out.println (str.length());
	}catch(Exception e){
		System.out.println("NullPointerException..");
	}
}
void Ex5()
{

	try{
	 String str="asdfghjkip";
	 System.out.println(str.length());;
	 char c = str.charAt(0);
	 c = str.charAt(40);
	 System.out.println(c);
      }catch(Exception e){
	  System.out.println("StringIndexOutOfBoundsException!!");
       }
}

public static void main(String[] args)
{
	Demo_Exception d=new Demo_Exception();
	d.Ex1(3,0);
	d.Ex2();
	d.Ex3();
	d.Ex4();
	d.Ex5();

}

}