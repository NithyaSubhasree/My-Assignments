package week3.day2;

import java.util.ArrayList;
import java.util.List;

public class FindIntersection {

	public static void main(String[] args) {
		/* a) Declare An array for {3,2,11,4,6,7};	 
		 * b) Declare another array for {1,2,8,4,9,7};
		 * c) Declare for loop iterator from 0 to array length
		 * d) Declare a nested for another array from 0 to array length
		 * e) Compare Both the arrays using a condition statement
		 *  f) Print the first array (should match item in both arrays)
		 */
	int[] ar1 = {3,2,11,4,6,7};
	int[] ar2 = {1,2,8,4,9,7};
	List<Integer> inter=new ArrayList <Integer>();
	for (int i = 0; i < ar1.length; i++) {
		inter.add(ar1[i]);	
	}
	System.out.println("First List : " +inter);
	
	List<Integer> inter1=new ArrayList<Integer>();
	for (int j = 0; j < ar2.length; j++) {
	inter1.add(ar2[j]);
	}
	System.out.println("Second List : " +inter1);
	
	System.out.println("Intersection of two list is : ");
	
	for (int i = 0; i < inter.size(); i++) {
		for (int j = 0; j < inter1.size(); j++) {
			if (inter.get(i).equals(inter1.get(j))) {
					System.out.println(inter.get(i));
			}
		}
		
	}
	}
}
