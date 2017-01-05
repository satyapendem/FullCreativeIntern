import java.util.*;
public class HashMaps {

   public static void main(String args[]) {

      HashMap hm = new HashMap();
      hm.put("Satya", new Double(3434.34));
      hm.put("sandy ", new Double(123.22));
      hm.put("Murthy", new Double(1378.00));
      hm.put("Chaitu", new Double(99.22));
      hm.put("Chinni", new Double(-19.08));
      
      Set set = hm.entrySet();
      
      Iterator i = set.iterator();
      
      while(i.hasNext()) {
         Map.Entry me = (Map.Entry)i.next();
         System.out.print(me.getKey() + ": ");
         System.out.println(me.getValue());
      }
      System.out.println();
      
      double balance = ((Double)hm.get("Satya")).doubleValue();
      hm.put("Zara", new Double(balance + 1000));
      System.out.println("Satya new balance: " + hm.get("Satya"));
   }
}