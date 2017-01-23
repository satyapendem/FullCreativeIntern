public class Break_ContinueEx {
  
    public static void main(String args[]) {
    
        int[] numbers= new int[]{1,2,3,4,5,6,7,8,9,10};
      
        
        int sum = 0;
        for(int i=0; i< numbers.length; i++){
            System.out.println("Loop iteration number: " + i);
            if(i == 5){
                break;
            }
            if(i%2 != 0){
                sum = sum + i;
                continue;
            }
        }
        System.out.println("Outside: " + sum);
    }
}