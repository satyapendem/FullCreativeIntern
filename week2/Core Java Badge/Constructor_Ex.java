class Constructor_Ex{  
    int id;  
    String name;  
      
    Constructor_Ex(int i,String n){  
    id = i;  
    name = n;  
    }  
    void display(){
        System.out.println(id+" "+name);
    }  
   
    public static void main(String args[]){  
    Constructor_Ex s1 = new Constructor_Ex(111,"satya");  
    Constructor_Ex s2 = new Constructor_Ex(516,"chaitu");  
    s1.display();  
    s2.display();  
   }  
}  