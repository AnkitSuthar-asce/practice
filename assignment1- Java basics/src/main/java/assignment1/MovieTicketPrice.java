package assignment1;
import java.util.Scanner;

import java.util.Scanner;

public class MovieTicketPrice {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	    System.out.print("Enter Your Age: ");
	    int age=sc.nextInt();
	    if(age<12){
	        System.out.println("Movie Ticket Price: 100");
	    }
	    else if(age>=12 && age<60){
	        System.out.println("Movie Ticket Price: 200");
	    }
	    else{
	        System.out.println("Movie Ticket Price: 120");
	    }
	}
}
