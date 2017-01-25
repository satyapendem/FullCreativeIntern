import java.util.*;
public class ListMapDemo{

   public static void main(String[] args) {

      /*Information about list
        1.List class can contain duplicate elements.
        2.List class maintains insertion order.
        3.when we call list the default size is 10.
        4.We will use list when there is a need of duplicates. 
      */
      List a1 = new ArrayList();
      a1.add("A");
      a1.add("B");
      a1.add("C");      
      System.out.println(" ArrayList Elements");
      System.out.print("\t" + a1);
      /*

        1.It will store data in the form of Key,value pair.
        2.It does not maintain insertion order.
        3.It stores data in a sorted oder.
        4.It does not support but it supports null values.
      */
     Map m1 = new HashMap(); 
      m1.put(515,"satya");
      m1.put(516,"chaitu");
      m1.put(527,"siva");
      m1.put(521, "redddy");
      System.out.println();
      System.out.println(" Map Elements");
      System.out.print("\t" + m1);

      /*
        1.A set does not allow duplicate values.
        2.A set can allow one null value.
        3.It can store values based on hashing.
        4.It does not maintain insertion order.
      */
   HashSet<String> set=new HashSet<String>();  
  set.add(null);
  set.add("satya");  
  set.add("chaitu");  
  set.add("redddy");  
  set.add("satya");    
  System.out.println();
  System.out.println("The elements in set are:"); 
  Iterator<String> itr=set.iterator();  
  while(itr.hasNext()){  
   System.out.println(itr.next());  

   }
}
}