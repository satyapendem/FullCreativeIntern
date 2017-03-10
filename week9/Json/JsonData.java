package json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class JsonData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int value;
		String tit;
		int i=0;
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		while(i==0){
		Scanner sc=new Scanner(System.in);
		System.out.println("enter title:");		
	    tit=sc.next();
	    System.out.println("enter value");
	    value=sc.nextInt();
		map.put("title", tit);
		map.put("value", value);
		list.add(map);
		System.out.println("do you want add again enter 0:");
		i=sc.nextInt();
		if(i!=0)
		{
			break;
		}
		}
		System.out.println(list);
		}
	}

