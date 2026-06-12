package assignment1;
import java.util.Scanner;

public class LoginValidation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String username = sc.next();
        System.out.print("Enter Password: ");
        String password = sc.next();
        if (username.equals("admin") && password.equals("1234")) {
            System.out.println("success login");
        } else {
            System.out.println("invalid cred");
        }
        sc.close();
    }
}
