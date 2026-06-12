package assignment1;
import java.util.Scanner;
import java.util.Arrays;

public class PalindromeArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) { arr[i] = sc.nextInt(); }
        
        System.out.println("Array: " + Arrays.toString(arr));
        boolean isPal = true;
        for (int i = 0; i < n / 2; i++) {
            if (arr[i] != arr[n - 1 - i]) {
                isPal = false;
                break;
            }
        }
        System.out.println("Is Palindrome?: " + isPal);
        sc.close();
    }
}

