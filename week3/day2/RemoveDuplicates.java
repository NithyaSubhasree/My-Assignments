package week3.day2;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicates {

	public static void main(String[] args) {
		String text = "We learn java basics as part of java sessions in java week1";
		String[] str = text.split(" ");
		int count=0;
		//List<String> lst = new ArrayList <String> (Arrays.asList(text));
		List<String> lst = new ArrayList<String>();
		
		for (int i = 0; i < str.length; i++) {
			lst.add(str[i]);
		}
		System.out.println(lst);
		for (int j = 0; j < lst.size(); j++) {
			for (int k = j+1; k < lst.size(); k++) {
				if(lst.get(j).equals(lst.get(k))) {
					count=count+1;
				}
				
			}
			if (count>1) {
				text=text.replace(lst.get(j), " ");
				break;
			}
		}
	System.out.println("Removed Duplicates: " +text);
	}
	

}
