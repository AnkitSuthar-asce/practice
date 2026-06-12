package assignment3;
import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private String accountType;

    public BankAccount(String accountNumber, String accountHolderName, double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        if (balance >= 1000) {
            this.balance = balance;
        } 
        else {
            System.out.println("Error: Initial balance must be at least ₹1000. Setting to ₹1000.");
            this.balance = 1000;
        }
        this.setAccountType(accountType);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountHolderName(String accountHolderName) {
        if (accountHolderName != null && !accountHolderName.trim().isEmpty()) {
            this.accountHolderName = accountHolderName;
        } 
        else {
            System.out.println("Invalid Name!");
        }
    }

    public void setAccountType(String accountType) {
        if (accountType.equalsIgnoreCase("Savings") || accountType.equalsIgnoreCase("Current")) {
            this.accountType = accountType;
        } 
        else {
            System.out.println("Invalid Account Type! Defaulting to Savings.");
            this.accountType = "Savings";
        }
    }

    public void deposit(double amount) {
        if (amount > 0 && amount < 50000) {
            balance += amount;
            System.out.println("Depositing ₹" + amount + "... Deposit successful! New Balance: ₹" + balance);
        } 
        else {
            System.out.println("Deposit failed! Amount must be positive and less than ₹50,000.");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= 1000) {
            balance -= amount;
            System.out.println("Withdrawing ₹" + amount + "... Withdrawal successful! New Balance: ₹" + balance);
        } 
        else {
            System.out.println("Attempting to withdraw ₹" + amount + "... Insufficient balance! (Minimum ₹1000 must be maintained).");
        }
    }
    public void displayAccountInfo() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name   : " + accountHolderName);
        System.out.println("Account Type  : " + accountType);
        System.out.println("Balance       : ₹" + balance);
    }
}

public class BankAccountManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Account Number: ");
        String accNum = sc.next();
        sc.nextLine(); 
        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        double bal = sc.nextDouble();
        System.out.print("Enter Account Type (Savings/Current): ");
        String type = sc.next();
        System.out.println("\nCreating Account... (" + accNum + ", " + name + ", ₹" + bal + ")");
        BankAccount account = new BankAccount(accNum, name, bal, type);
        System.out.print("\nEnter amount to deposit: ");
        double depositAmount = sc.nextDouble();
        account.deposit(depositAmount);
        System.out.print("\nEnter amount to withdraw: ");
        double withdrawAmt1 = sc.nextDouble();
        account.withdraw(withdrawAmt1);
        System.out.print("\nEnter another amount to withdraw: ");
        double withdrawAmt2 = sc.nextDouble();
        account.withdraw(withdrawAmt2);
        account.displayAccountInfo();
        sc.close();
    }
}
