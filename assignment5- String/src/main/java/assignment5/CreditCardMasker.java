package assignment5;

import java.util.Scanner;

public class CreditCardMasker {
    String number;
    public void masking() {
        String lastFour = number.substring(number.length() - 4);
        System.out.println("Masked CARD number: ****-****-****-" + lastFour);
    }
    public CreditCardMasker(String number) {
        this.number = number;
        masking();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputNumber;
        String regex = "\\d{4}-\\d{4}-\\d{4}-\\d{4}";
        while (true) {
            System.out.print("Enter Card Number (xxxx-xxxx-xxxx-xxxx): ");
            inputNumber = sc.nextLine();
            if (inputNumber.matches(regex)) {
                break;
            } else {
                System.out.println("Invalid format! Please use xxxx-xxxx-xxxx-xxxx (digits only).");
            }
        }
        new CreditCardMasker(inputNumber);
        sc.close();
    }
}
