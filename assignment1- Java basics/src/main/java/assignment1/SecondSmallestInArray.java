package assignment1;
import java.util.Scanner;
import java.util.Arrays;

public class SecondSmallestInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + i + ": ");
            arr[i] = sc.nextInt();
        }
        System.out.println("Array: " + Arrays.toString(arr));
        int min = Integer.MAX_VALUE, secMin = Integer.MAX_VALUE, pos = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] < min) {
                secMin = min;
                min = arr[i];
            } else if (arr[i] < secMin && arr[i] != min) {
                secMin = arr[i];
                pos = i;
            }
        }
        System.out.println("Second Smallest: " + secMin + " at Position: " + pos);
        sc.close();
    }
}

