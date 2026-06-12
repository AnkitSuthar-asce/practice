package assignment1;
import java.util.Scanner;

public class LargestOfThree {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter A: ");
		int a= sc.nextInt();
		System.out.print("Enter B: ");
		int b= sc.nextInt();
		System.out.print("Enter C: ");
		int c= sc.nextInt();
		if (a >= b) {
		    if (a >= c) {
		    	System.out.println(a + " A is the largest.");
		    }
		    else {
		    	System.out.println(b + " B is the largest.");
		    }
		} 
		else {
		    if (b >= c) { 
		    	System.out.println(b + " B is the largest.");
		    }
		    else { 
		    	System.out.println(c + " C is the largest.");
		    }
		}


	}

}
