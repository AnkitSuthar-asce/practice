package assignment1;
import java.util.Scanner;
import java.util.Arrays;

public class LeftRotate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter K positions to rotate: ");
        int k = sc.nextInt();
        k = k % n;
        System.out.println("Original: " + Arrays.toString(arr));
        for (int i = 0; i < k; i++) {
            int first = arr[0];
            for (int j = 0; j < n - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[n - 1] = first;
        }
        System.out.println("Rotated: " + Arrays.toString(arr));
        sc.close();
    }
}

