package assignment1;

import java.util.Scanner;

public class OddEvenPrint {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Number: ");
		int n= sc.nextInt();
		if(n==0){
			System.out.println("Zero");			
		}
		else if(n%2==0){
			System.out.println("Even");			
		}		
		else{
			System.out.println("Odd");			
		}
	}
}
