package assignment1;
import java.util.Scanner;

public class ExamResult {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Marks : ");
	    int marks=sc.nextInt();
	    System.out.print("Enter Attendance : ");
	    int att=sc.nextInt();
	    
	    if(marks>=50){
	        if(att>=75){
	            System.out.println("Pass with all criteria");
	        }
	        else{
	            System.out.println("Fail : Passing Marks but Low Attendace ");
	        }
	    }
	    else{
	        if(att>=75){
	            System.out.println("Fail : No Passing Marks Even After Good Attendance");
	        }
	        else{
	            System.out.println("Fail : No Passing Marks & No Good Attendance");
	        }
	    }
	}

}
