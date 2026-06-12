package assignment1;
import java.util.Scanner;

public class SalaryBonusCalculation {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Salary: ");
		double sal= sc.nextDouble();
		System.out.print("Enter Experience: ");
		int exp= sc.nextInt();
		
		if(exp<1) {
			System.out.println("No Bonus");
		}
		else if(exp>1 && exp<5) {
			System.out.println("Bonus(5%): "+(0.05*sal));
		}
		else if(exp>4 && exp<11) {
			System.out.println("Bonus(10%): "+(0.1*sal));
		}
		else {
			System.out.println("Bonus(20%): "+(0.2*sal));
		}

	}

}
