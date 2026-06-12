package assignment1;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter First: ");
        double num1 = sc.nextDouble();
        System.out.print("Enter Operator(+,-,/,*): ");
        char operator = sc.next().charAt(0);
        System.out.print("Enter Second: ");
        double num2 = sc.nextDouble();
        switch (operator) {
            case '+':
                System.out.println("Sum: "+(num1 + num2));
                break;
            case '-':
                System.out.println("Sub: "+(num1 - num2));
                break;
            case '*':
                System.out.println("Mult: "+(num1 * num2));
                break;
            case '/':
                if (num2 != 0) {
                    System.out.println("Div: "+(num1 / num2));
                } else {
                    System.out.println("Error: Division by zero");
                }
                break;
            default:
                System.out.println("Invalid operator");
                break;
        }
        sc.close();
    }
}
