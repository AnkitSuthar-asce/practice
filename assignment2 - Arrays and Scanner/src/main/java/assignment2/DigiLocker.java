package assignment2;
import java.util.Scanner;
import java.util.Arrays;

public class DigiLocker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter security code:");
        int securityCode = sc.nextInt();
        String codeString = String.valueOf(securityCode);
        int size = codeString.length();
        int[] digitArray = new int[size];
        boolean triggerFound = false;
        for (int i = 0; i < size; i++) {
            digitArray[i] = Character.getNumericValue(codeString.charAt(i));
            if (digitArray[i] == 5) {
                triggerFound = true;
            }
        }
        int[] transformedArray = new int[size];
        int totalSum = 0;
        for (int i = 0; i < size; i++) {
            if (digitArray[i] % 2 == 0) {
                transformedArray[i] = digitArray[i] * digitArray[i];
            } else {
                transformedArray[i] = digitArray[i] * digitArray[i] * digitArray[i];
            }
            totalSum += transformedArray[i];
        }
        int finalValue = totalSum;
        if (finalValue % 2 == 0) {
            finalValue = finalValue / 2;
        } else {
            finalValue = (finalValue * 3) + 1;
        }
        String securityLevel = "";
        if (finalValue <= 50) {
            securityLevel = "Weak";
        } else if (finalValue <= 150) {
            securityLevel = "Moderate";
        } else if (finalValue <= 300) {
            securityLevel = "Strong";
        } else {
            securityLevel = "Ultra Strong";
        }
        System.out.println("Original Code: " + securityCode);
        String sequence = Arrays.toString(transformedArray);
        System.out.println("Transformed Sequence: " + sequence.substring(1, sequence.length() - 1));
        System.out.println("Transformed Sum: " + totalSum + " \nFinal Value: " + finalValue);
        System.out.println("Security Level: " + securityLevel);
        if (triggerFound) {
            System.out.println("Hidden Security Trigger Activated!");
        }
        sc.close();
    }
}


