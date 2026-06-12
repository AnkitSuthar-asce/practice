package assignment1;

import java.util.Scanner;

public class StudentGrade {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Marks: ");
		double n= sc.nextDouble();
		if(n>=90){
			System.out.println("Grade A");			
		}
		else if(n>=75 && n<=89){
			System.out.println("Grade B");			
		}		
		else if(n>=50 && n<=74){
			System.out.println("Grade C");			
		}
		else {
			System.out.println("Fail");
		}
				
	}

}
