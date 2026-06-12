package assignment1;
import java.util.Scanner;
import java.util.Arrays;

public class StudentStats {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[] marks = new int[n];
        int sum = 0, high = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter marks: ");
            marks[i] = sc.nextInt();
            sum += marks[i];
            if (marks[i] > high) { high = marks[i]; }
        }
        double avg = (double) sum / n;
        int above = 0;
        for (int m : marks) { if (m > avg) { above++; } }
        
        System.out.println("Marks: " + Arrays.toString(marks));
        System.out.println("Average: " + avg + ", Highest: " + high + ", Above Average: " + above);
        sc.close();
    }
}

