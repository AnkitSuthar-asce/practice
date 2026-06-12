package assignment1;
import java.util.Scanner;
import java.util.Arrays;

public class OddEvenCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter total numbers: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        int even = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter number: ");
            arr[i] = sc.nextInt();
            if (arr[i] % 2 == 0) {
                even++;
            }
        }
        System.out.println("Input Array: " + Arrays.toString(arr));
        System.out.println("Even count: " + even + ", Odd count: " + (n - even));
        sc.close();
    }
}

