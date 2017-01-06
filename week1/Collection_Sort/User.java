import java.util.*;
import java.io.*;
public class Mobile implements Comparable<User> {

    private String Mobilename;

    public String getMobile() {
        return Mobilename;
    }

    public void setMobile(String Mobilename) {
        this.Mobilename = Mobilename;
    }
    @Override
    public int compareTo(User obj) {
        if(obj != null && obj.Mobilename != null){
             return this.Mobilename.compareTo(obj.Mobilename);
   
        }else{
            return -1;
        }
    }
}