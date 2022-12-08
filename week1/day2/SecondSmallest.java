package week1.day2;

public class SecondSmallest {

	public static void main(String[] args) {
		int [] num = {23,45,67,32,89,22};
		int small;
		for (int i=0; i<num.length; i++) {
			for (int j=i; j<num.length-1; j++) {
				if (num[i] < num[j+1]) {
					small=num[i];
					num[i]=num[j+1];
					num[j+1]=small;
				}
			}
			System.out.println("The smallest number is " +num[1]);
			break;
		}

	}

}
