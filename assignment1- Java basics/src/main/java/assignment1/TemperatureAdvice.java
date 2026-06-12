package assignment1;
import java.util.Scanner;

public class TemperatureAdvice {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	    System.out.print("Enter Temperature: ");
	    double temp=sc.nextDouble();
	    if(temp<15){
	        System.out.println("Cold");
	    }
	    else if(temp>=15 && temp<=24){
	        System.out.println("Cool");
	    }
	    else if(temp>=25 && temp<=35){
	        System.out.println("Warm");
	    }
	    else{
	        System.out.println("Very hot");
	    }
	}
}