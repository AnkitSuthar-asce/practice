package assignment1;
import java.util.Scanner;

public class ElectricityBill {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	    System.out.print("Total Unit Consumed :");
	    int units=sc.nextInt();
	    if(units<=100){
	        System.out.println("Bill: "+units*2);
	    }
	    else if(units<=300){
	        System.out.println("Bill: "+( ((units-100)*3)+200));
	    }
	    else{
	        System.out.println("Bill: "+(800+((units-300)*5)));
	    }  
	}
}
