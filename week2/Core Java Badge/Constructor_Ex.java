class A
{
  int a;
  String b; 

  A(int x){
  	this.a=x;
  	System.out.println("The id n base class is:"+a);
  } 
}
class Constructor_Ex extends A{  
    int id;  
    String name;  
      
    Constructor_Ex(int id,String name){  
    super(id);
    this.id = id;  
    this.name = name;  
    }  
    void display(){
    	
        System.out.println(id+" "+name);
    }  
   
    public static void main(String args[]){  
    Constructor_Ex s1 = new Constructor_Ex(515,"satya");  
    Constructor_Ex s2 = new Constructor_Ex(516,"chaitu");  
    s1.display();  
    s2.display();  
   }  
}  