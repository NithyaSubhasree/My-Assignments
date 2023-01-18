package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Missing {
public static void main(String[] args) {
	int[] arr = {1,2,3,4,7,6,8};
	List<Integer>lst=new ArrayList<Integer>();
	for(int i=0;i<arr.length;i++)
	{
		lst.add(arr[i]);
	}
	Collections.sort(lst);
	System.out.println("The sorted list is :"+lst);
	for(int i=0;i<lst.size()-1;i++)
	{
			if(lst.get(i+1)!=lst.get(i)+1)
			{
				System.out.println("The missing Element is :"+ (lst.get(i)+1));
				break;
}
}
}
}