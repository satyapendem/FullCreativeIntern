package smallest;

public class Optimized_Check {
	public static void main(String[] args){
		
		int n=20;
		long startTime = System.currentTimeMillis();
		while(!check(n)){
			n=n+20;
		}
		System.out.println(n);
		 long endTime   = System.currentTimeMillis();
		 long totalTime = endTime - startTime;
		 System.out.println(totalTime);
	}
	static boolean check(int x)
	{
		for(int i=2;i<=20;i++){
			if(x%i!=0)
			{
				return false;
			}
		}
		return true;	
	}			
}