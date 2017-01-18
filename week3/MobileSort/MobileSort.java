import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class MobileSort {
	
	public static void main(String[] args) {
 
		List<Mobile> list = new ArrayList<Mobile>();
		list.add(new Mobile("Asus Zenfone2",300000,5,"Dual core"));
		list.add(new Mobile("Asus Zenfone",700000,4,"Dual core"));
		list.add(new Mobile("Google pixel",100000,8,"Octa core"));
		list.add(new Mobile("Nexus",30000,4,"Quad core"));
		list.add(new Mobile("Mi",450000,4,"Octa core"));
		
		try{
			Comparator c1 = CustomComparator.getComparator("Mobile", "price", 0);
			Collections.sort(list, c1);
			for(Mobile e : list){
				System.out.println(e.getMobileName() + "," + e.getPrice() + "," + e.getRam() + "," + 
						e.getProcessor());
			}
			System.out.println();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		try{
			Comparator c1 = CustomComparator.getComparator("Mobile", "price", 1);
			Collections.sort(list, c1);
			for(Mobile e : list){
				System.out.println(e.getMobileName() + "," + e.getPrice() + "," + e.getRam() + "," + 
						e.getProcessor());
			}
			System.out.println();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		try{
			Comparator c1 = CustomComparator.getComparator("Mobile", "mobileName", 0);
			Collections.sort(list, c1);
			for(Mobile e : list){
				System.out.println(e.getMobileName() + "," + e.getPrice() + "," + e.getRam() + "," + 
						e.getProcessor());
			}
			System.out.println();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		try{
			Comparator c1 = CustomComparator.getComparator("Mobile", "mobileName", 1);
			Collections.sort(list, c1);
			for(Mobile e : list){
				System.out.println(e.getMobileName() + "," + e.getPrice() + "," + e.getRam() + "," + 
						e.getProcessor() );
			}
			System.out.println();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		try{
			Comparator c1 = CustomComparator.getComparator("Mobile", "ram", 0);
			Collections.sort(list, c1);
			for(Mobile e : list){
				System.out.println(e.getMobileName() + "," + e.getPrice() + "," + e.getRam() + "," + 
						e.getProcessor());
			}
			System.out.println();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		try{
			Comparator c1 = CustomComparator.getComparator("Mobile", "ram", 1);
			Collections.sort(list, c1);
			for(Mobile e : list){
				System.out.println(e.getMobileName() + "," + e.getPrice() + "," + e.getRam() + "," + 
						e.getProcessor());
			}
			System.out.println();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
