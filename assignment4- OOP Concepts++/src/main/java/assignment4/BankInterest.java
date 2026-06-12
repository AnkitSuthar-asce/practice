package assignment4;
import java.util.Scanner;

abstract class Account {
    String accountNumber;
    double balance;
    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public void deposit(double amount) {
        balance += amount;
    }
    public void printAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + balance);
    }
    public abstract double calculateInterest();
}

class SavingsAccount extends Account {
    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }
    public double calculateInterest() {
        return balance * 0.04;
    }
}

class CurrentAccount extends Account {
    public CurrentAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }
    public double calculateInterest() {
        return 0.0;
    }
}

public class BankInterest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Savings Account Number: ");
        String sAcc = sc.nextLine();
        System.out.print("Enter Savings Initial Balance: ");
        double sBal = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter Current Account Number: ");
        String cAcc = sc.nextLine();
        System.out.print("Enter Current Initial Balance: ");
        double cBal = sc.nextDouble();
        SavingsAccount savings = new SavingsAccount(sAcc, sBal);
        CurrentAccount current = new CurrentAccount(cAcc, cBal);
        System.out.println("\n--- Savings Account ---");
        savings.printAccountDetails();
        System.out.println("Interest: " + savings.calculateInterest());
        System.out.println("\n--- Current Account ---");
        current.printAccountDetails();
        System.out.println("Interest: " + current.calculateInterest());
        sc.close();
    }
}
