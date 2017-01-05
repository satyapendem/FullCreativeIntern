import java.util.Hashtable;
import java.util.Enumeration;

public class HashTables {
 
 public static void main(String[] args) {
 
   Enumeration names;
   String key;
 
   Hashtable<String, String> hashtable = 
              new Hashtable<String, String>();
 
   hashtable.put("Key1","Chaitanya");
   hashtable.put("Key2","chaitu");
   hashtable.put("Key3","satya");
   hashtable.put("Key4","sandy");
   hashtable.put("Key5","murthy");
 
   names = hashtable.keys();
   while(names.hasMoreElements()) {
      key = (String) names.nextElement();
      System.out.println("Key: " +key+ " & Value: " +
      hashtable.get(key));
   }
 }
}