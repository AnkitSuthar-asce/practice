package assignment4;
import java.util.Scanner;

interface Rentable {
    double calculateRent(int days);
    void displayDetails(int days);
}

class Car implements Rentable {
    String brand;
    double dailyRate;

    public Car(String brand, double dailyRate) {
        this.brand = brand;
        this.dailyRate = dailyRate;
    }
    public double calculateRent(int days) {
        return days * dailyRate;
    }
    public void displayDetails(int days) {
        System.out.println("Car Brand: " + brand);
        System.out.println("Total Rent for " + days + " days: " + (int)calculateRent(days));
    }
}

class Bike implements Rentable {
    String brand;
    double dailyRate;

    public Bike(String brand, double dailyRate) {
        this.brand = brand;
        this.dailyRate = dailyRate;
    }
    public double calculateRent(int days) {
        return days * dailyRate;
    }
    public void displayDetails(int days) {
        System.out.println("Bike Brand: " + brand);
        System.out.println("Total Rent for " + days + " days: " + (int)calculateRent(days));
    }
}

public class VechileRentalSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Car Brand: ");
        String carBrand = sc.nextLine();
        System.out.print("Enter Car Daily Rate: ");
        double carRate = sc.nextDouble();
        System.out.print("Enter Rental Days for Car: ");
        int carDays = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter Bike Brand: ");
        String bikeBrand = sc.nextLine();
        System.out.print("Enter Bike Daily Rate: ");
        double bikeRate = sc.nextDouble();
        System.out.print("Enter Rental Days for Bike: ");
        int bikeDays = sc.nextInt();

        Rentable car = new Car(carBrand, carRate);
        Rentable bike = new Bike(bikeBrand, bikeRate);

        System.out.println("\n--- Rental Details ---");
        car.displayDetails(carDays);
        bike.displayDetails(bikeDays);

        sc.close();
    }
}
