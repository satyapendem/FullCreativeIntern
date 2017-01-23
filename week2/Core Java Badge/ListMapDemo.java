import java.util.*;
public class ListMapDemo{

   public static void main(String[] args) {
      List a1 = new ArrayList();
      a1.add("A");
      a1.add("B");
      a1.add("C");      
      System.out.println(" ArrayList Elements");
      System.out.print("\t" + a1);

     Map m1 = new HashMap(); 
      m1.put("satya", "515");
      m1.put("chaitu", "516");
      m1.put("reddy", "521");
      m1.put("siva", "527");

      System.out.println();
      System.out.println(" Map Elements");
      System.out.print("\t" + m1);
   }
}