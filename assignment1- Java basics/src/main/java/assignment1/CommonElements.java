package assignment1;
import java.util.Scanner;
import java.util.Arrays;

public class CommonElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Size of Array 1: ");
        int[] a1 = new int[sc.nextInt()];
        for(int i=0; i<a1.length; i++) { a1[i] = sc.nextInt(); }
        
        System.out.print("Size of Array 2: ");
        int[] a2 = new int[sc.nextInt()];
        for(int i=0; i<a2.length; i++) { a2[i] = sc.nextInt(); }

        System.out.println("Arr1: " + Arrays.toString(a1));
        System.out.println("Arr2: " + Arrays.toString(a2));
        System.out.print("Common elements: ");
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a2.length; j++) {
                if (a1[i] == a2[j]) {
                    System.out.print(a1[i] + " ");
                    break;
                }
            }
        }
        sc.close();
    }
}

