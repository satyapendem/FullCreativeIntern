import java.io.*;
import java.util.*;
public class Demo_Exception{  
  public static void main(String args[]){  
   try{  
    int a[]=new int[5];  
    a[5]=30/0;  
    System.out.println(a[7]);
   }  
   catch(ArithmeticException | ArrayIndexOutOfBoundsException e){
    System.out.println(e);
    }      
 }  
}  