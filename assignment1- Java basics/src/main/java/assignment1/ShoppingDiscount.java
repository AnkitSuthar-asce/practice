package assignment1;
import java.util.Scanner;

public class ShoppingDiscount {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	    System.out.print("Enter Purchase Amount : ");
	    int purchase=sc.nextInt();
	    if(purchase<1000){
	        System.out.println("Sorry No Discount");
	        System.out.println("Bill :"+purchase);
	    }
	    else if(purchase>=1000 && purchase<3000){
	        System.out.println("10% Discount");
	        System.out.println("Bill :"+(purchase-(0.1*purchase)));
	    }
	    else if(purchase>=3000 && purchase<5000){
	        System.out.println("20% Discount");
	        System.out.println("Bill :"+(purchase-(0.2*purchase)));
	    }
	    else{
	        System.out.println("30% Discount");
	        System.out.println("Bill :"+(purchase-(0.3*purchase)));	        
	    }
	}

}
