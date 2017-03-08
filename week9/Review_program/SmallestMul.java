package smallest;

public class SmallestMul {
	public static void main(String[] args)
	{
		int a,num,flag=0;
		 for(num=1; ; num++)
		 {
		 for(a=1;a<=20;a++)
		 {
			 if(num%a==0)
			 {
				flag++;
			 }
			 
		 }
		 if(flag==20)
		 {
			 System.out.println(num);
			 break;
		 }
		
		flag=0;
     }
	}

}
