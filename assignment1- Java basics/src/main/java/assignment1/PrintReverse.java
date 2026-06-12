package assignment1;
import java.util.Scanner;
import java.util.Arrays;

public class PrintReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) { arr[i] = sc.nextInt(); }
        
        System.out.println("Original Array: " + Arrays.toString(arr));
        System.out.print("Reverse order: ");
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}

