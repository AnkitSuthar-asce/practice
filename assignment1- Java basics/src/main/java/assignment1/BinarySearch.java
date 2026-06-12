package assignment1;
import java.util.Scanner;
import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
        System.out.print("Enter element to search: ");
        int s = sc.nextInt();
        int left = 0, right = n - 1;
        boolean found = false;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == s) {
                System.out.println("Element found at index: " + mid);
                found = true;
                break;
            }
            if (arr[mid] < s) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (!found) {
            System.out.println("Element not found");
        }
        sc.close();
    }
}
