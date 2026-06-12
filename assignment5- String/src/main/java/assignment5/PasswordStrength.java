package assignment5;
import java.util.Scanner;

public class PasswordStrength {
    private String name;
    private String password;
    private void Strength() {
        if (password.length() < 8) {
            System.out.println("Weak Password: Must be at least 8 characters long.");
            return;
        }
        int u = 0, l = 0, d = 0, s = 0;
        for (char a : password.toCharArray()) {
            if (Character.isWhitespace(a)) {
                System.out.println("Invalid Password: No spaces allowed.");
                return;
            }
            if (Character.isUpperCase(a)) u++;
            else if (Character.isLowerCase(a)) l++;
            else if (Character.isDigit(a)) d++;
            else s++;
        }
        if (u >= 1 && l >= 1 && d >= 1 && s >= 1) {
            System.out.println("Strong Password");
        } else {
            System.out.println("Weak Password: Must include uppercase, lowercase, digit, and special character.");
        }
    }

    public PasswordStrength(String name, String password) {
        this.name = name;
        this.password = password;
        Strength();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Email: ");
        String nameInput = sc.nextLine();
        System.out.print("Enter Password: ");
        String passInput = sc.nextLine();
        new PasswordStrength(nameInput, passInput);
        sc.close();
    }
}
