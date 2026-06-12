package assignment1;
import java.util.Scanner;

public class VotingEligibility {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Age: ");
		int a= sc.nextInt();
		if(a>=18 && a<100) {
			System.out.println("Eligible");
		}
		else if(a<18) {
			System.out.println("Not Eligible");
		}
		else {
			System.out.println("Invalid Age");
		}
	}
}
