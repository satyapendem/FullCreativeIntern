import java.io.*;
import java.util.*;
public class String_Builder_ex{  
    public static void main(String[] args){  
        long startTime = System.currentTimeMillis();  
        StringBuffer sb = new StringBuffer("satye");  
        for (int i=0; i<10000; i++){  
            sb.append("murthy");  
        }  
        System.out.println("Time taken by StringBuffer: " + (System.currentTimeMillis() - startTime) + "ms");  
        startTime = System.currentTimeMillis();  
        StringBuilder sb2 = new StringBuilder("satya");  
        for (int i=0; i<100; i++){  
            sb2.append("murthy");  
        }  
        System.out.println("Time taken by StringBuilder: " + (System.currentTimeMillis() - startTime) + "ms");  
    }  
}  