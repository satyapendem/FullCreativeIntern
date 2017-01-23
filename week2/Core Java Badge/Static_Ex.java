class Static_Ex{  
   int rollno;  
   String name;  
   static String college ="KIET";  
     
   Static_Ex(int r,String n){  
   rollno = r;  
   name = n;  
   }  
 void display (){System.out.println(rollno+" "+name+" "+college);}  
  
 public static void main(String args[]){  
 Static_Ex s1 = new Static_Ex(515,"satya");  
 Static_Ex s2 = new Static_Ex(516,"chaitu");  
   
 s1.display();  
 s2.display();  
 }  
}  