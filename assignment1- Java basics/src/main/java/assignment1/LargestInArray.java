package assignment1;
import java.util.Scanner;
import java.util.Arrays;

public class LargestInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Array: " + Arrays.toString(arr));
        int max = arr[0], pos = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
                pos = i;
            }
        }
        System.out.println("Largest Number: " + max + " at Position: " + pos);
        sc.close();
    }
}


