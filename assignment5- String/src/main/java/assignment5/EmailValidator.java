package assignment5;

import java.util.Scanner;

public class EmailValidator {
    public String name;
    public String email;
    public String organizationname;
    public EmailValidator(String name, String email, String organizationname) {
        this.name = name;
        this.email = email;
        this.organizationname = organizationname;
    }
    public void validEmail() {
        String domain = "@" + organizationname.toLowerCase() + ".com";
        if (email.contains(" ")) {
            System.out.println("Status: Invalid Email (No spaces allowed)");
        } 
        else if (email.indexOf('@') != email.lastIndexOf('@')) {
            System.out.println("Status: Invalid Email (Multiple @)");
        } 
        else if (!email.toLowerCase().endsWith(domain)) {
            System.out.println("Status: Invalid Email (Must end with " + domain + ")");
        } 
        else {
            System.out.println("Status: Valid Email");
        }
    }
    public void data() {
        System.out.println("\n--- Employee Details ---");
        System.out.println("Name: " + name);
        System.out.println("Organization: " + organizationname);
        System.out.println("Email: " + email);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee Name: ");
        String nameInput = sc.nextLine();
        System.out.print("Enter Organization Name: ");
        String orgInput = sc.nextLine();
        System.out.print("Enter Email Address: ");
        String emailInput = sc.nextLine();
        EmailValidator vc = new EmailValidator(nameInput, emailInput, orgInput);
        vc.data();
        vc.validEmail();
        sc.close();
    }
}
