package assignment5;
import java.util.Scanner;

public class UserName {
    String firstName;
    String lastName;
    public UserName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        generateUsername();
    }
    public void generateUsername() {
        String username = (firstName + "." + lastName).replaceAll("\\s+", "").toLowerCase();
        System.out.println("Generated Username: " + username);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter First Name: ");
        String inputFirstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String inputLastName = scanner.nextLine();
        new UserName(inputFirstName, inputLastName);
        scanner.close();
    }
}
