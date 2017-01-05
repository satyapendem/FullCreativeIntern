import java.util.*;

public class ArrayLists {
   public static void main(String args[]) {
	  ArrayList<String> obj = new ArrayList<String>();
	  obj.add("satya");
	  obj.add("chaitu");
	  obj.add("Chaitanya");
	  obj.add("chinni");
	  obj.add("sandy");

	  System.out.println("Currently the array list has following elements:"+obj);
	  obj.add(0, "ganesh");
	  obj.add(1, "Jram");
	  obj.remove("Chaitanya");
	  obj.remove("sandy");

	  System.out.println("Current array list is:"+obj);
	  obj.remove(1);

	  System.out.println("Current array list is:"+obj);
   }
}