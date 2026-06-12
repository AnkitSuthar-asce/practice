package assignment1;
import java.util.Scanner;
import java.util.Arrays;

public class ProductDiscount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        double[] prices = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter price for product " + (i + 1) + ": ");
            prices[i] = sc.nextDouble() * 0.90;
        }
        System.out.println("Discounted Prices: " + Arrays.toString(prices));
        sc.close();
    }
}
