package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MissingElementInAnArray {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,7,6,8};
		// Sort the array	
		List <Integer> miss = new ArrayList <Integer>();
		for (int i = 0; i < arr.length; i++) {
			miss.add(arr[i]);
		}

		Collections.sort(miss);
		System.out.println("THe sorted list is : " +miss);

		// loop through the array (start i from arr[0] till the length of the array)
for (int i = 0; i < miss.size()-1; i++) {
	if(miss.get(i+1)!=miss.get(i)+1){
		System.out.println("The missing element is : " + miss.get(i)+1);
		break;
	}
}
			// check if the iterator variable is not equal to the array values respectively
			
				// print the number
				
				// once printed break the iteration
				
				
		


	}

}
