package assignment4;
import java.util.Scanner;

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    public String getName() {
        return name;
    }
    public double getSalary() {
        return salary;
    }
    public double calculateBonus(long salary) {
        return 0.05 * salary;
    }
    public static void printDetails(Employee e) {
        System.out.println("------------------------------------------");
        System.out.println("Employee Name: " + e.getName());
        System.out.println("Base Salary  : " + e.getSalary());
        System.out.println("Calculated Bonus: " + e.calculateBonus((long) e.getSalary()));
        System.out.println("------------------------------------------");
    }
}

class Manager extends Employee {
    public Manager(String name, double salary) {
        super(name, salary);
    }
    @Override
    public double calculateBonus(long salary) {
        return 0.1 * salary;
    }
}

class Developer extends Employee {
    public Developer(String name, double salary) {
        super(name, salary);
    }
    @Override
    public double calculateBonus(long salary) {
        return 0.07 * salary;
    }
}

public class payRoll {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter details for Manager:");
        System.out.print("Name: ");
        String mName = sc.nextLine();
        System.out.print("Salary: ");
        double mSalary = sc.nextDouble();
        sc.nextLine();
        System.out.println("\nEnter details for Developer:");
        System.out.print("Name: ");
        String dName = sc.nextLine();
        System.out.print("Salary: ");
        double dSalary = sc.nextDouble();
        sc.nextLine();
        System.out.println("\nEnter details for Employee:");
        System.out.print("Name: ");
        String eName = sc.nextLine();
        System.out.print("Salary: ");
        double eSalary = sc.nextDouble();
        Manager mgr = new Manager(mName, mSalary);
        Developer dev = new Developer(dName, dSalary);
        Employee emp = new Employee(eName, eSalary);
        System.out.println("\n--- Payroll Details ---");
        Employee.printDetails(mgr);
        Employee.printDetails(dev);
        Employee.printDetails(emp);
        sc.close();
    }
}

