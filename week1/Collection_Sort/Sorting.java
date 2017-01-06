import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Sorting{

    public static void main(String[] args) {
    
        User user1 = new User();
       
        user1.setMobile("Samsung");
        
        

        User user2 = new User();
        user2.setMobile("Asus");
        
        User user3 = new User();
        user3.setMobile("Nexus");
        
        User user4 = new User();
        user4.setMobile("LG");
        
        User user5 = new User();
        user5.setMobile("Google Pixel");
        
        User user6 = new User();
        user6.setMobile("Iphone");
        
        
        List<User> listUser = new ArrayList<User>();
        listUser.add(user4);
        listUser.add(user6);
        listUser.add(user1);
        listUser.add(user5);
        listUser.add(user2);
        listUser.add(user3);

        System.out.println("Default Mobile List");
        System.out.println("------------------------");
        for (User user : listUser) {
            System.out.println(user.getMobile());
        }
        System.out.println("---------------------------------");

        Collections.sort(listUser);
        System.out.println("Mobile List after Sorted by Name");
        System.out.println("-----------------------------------");
        for (User user : listUser) {
            System.out.println(user.getMobile());
        }
    }
}