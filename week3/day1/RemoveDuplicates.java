package week3.day1;

public class RemoveDuplicates {

	public static void main(String[] args) {
        //Use the declared String text as input
			String text = "We learn java basics as part of java sessions in java week1";	

		//Initialize an integer variable as count	  
        	int count=0;

		//Split the String into array and iterate over it 
        	String[] split = text.split(" ");
for (int i = 0; i < split.length; i++) {
	
	for (int j = i+1; j < split.length; j++) {
		if(split[i].equals(split[j])) {
			count = count +1;
		}
		if (count >1) {
			text=text.replace(split[i], "");
			break;
		}
	}
	
}        	
System.out.println("Text after removing duplicates is : " +text );

	}

}
