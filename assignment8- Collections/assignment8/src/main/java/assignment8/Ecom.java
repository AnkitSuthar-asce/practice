package assignment8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Ecom {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("P12345", "iPhone 15 Pro", "Electronics", 120000.0, 5, "TechWorld Store", 4.8));
        products.add(new Product("P23456", "Samsung TV 55\"", "Electronics", 50000.0, 3, "TechWorld Store", 4.6));
        products.add(new Product("P34567", "Nike Air Max", "Clothing", 80000.0, 150, "FashionHub", 4.4));
        products.add(new Product("P67890", "XYZ Shoes", "Clothing", 3000.0, 80, "FashionHub", 2.1));
        products.add(new Product("P78901", "ABC Dress", "Clothing", 4000.0, 90, "FashionHub", 4.2));

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("C00124", "Rahul Sharma", "rahul@test.com", "9876543210", "Mumbai", true, LocalDate.of(2020, 1, 15)));
        customers.add(new Customer("C00567", "Priya Patel", "priya@test.com", "9876543211", "Delhi", true, LocalDate.of(2021, 5, 20)));
        customers.add(new Customer("C00890", "Amit Kumar", "amit@test.com", "9876543212", "Bangalore", false, LocalDate.of(2022, 3, 10)));
        customers.add(new Customer("C00234", "Fraud Tester", "fraud@test.com", "9876543213", "Mumbai", false, LocalDate.of(2023, 8, 12)));

        List<Order> orders = new ArrayList<>();
        LocalDateTime todayTime = LocalDateTime.of(2025, 11, 13, 10, 0);
        LocalDateTime yesterdayTime = LocalDateTime.of(2025, 10, 13, 10, 0);

        orders.add(new Order("O1", "C00124", "P12345", 1, 120000.0, todayTime, "DELIVERED", "CARD", "Mumbai", true));
        orders.add(new Order("O2", "C00567", "P23456", 1, 50000.0, todayTime, "DELIVERED", "UPI", "Delhi", true));
        orders.add(new Order("O3", "C00890", "P34567", 2, 16000.0, todayTime, "PLACED", "COD", "Bangalore", false));
        orders.add(new Order("O4", "C00234", "P67890", 1, 3000.0, todayTime, "RETURNED", "WALLET", "Mumbai", false));
        orders.add(new Order("O5", "C00234", "P67890", 1, 3000.0, todayTime, "RETURNED", "WALLET", "Delhi", false));
        orders.add(new Order("O6", "C00890", "P78901", 6, 24000.0, yesterdayTime, "DELIVERED", "UPI", "Bangalore", false));

        LocalDate targetDate = LocalDate.of(2025, 11, 13);

        long ordersToday = OrderAnalytics.getOrdersPlacedToday(orders, targetDate);
        double totalRevenue = OrderAnalytics.getTotalRevenue(orders);
        double avgOrderValue = OrderAnalytics.getAverageOrderValue(orders);
        long cancelledCount = OrderAnalytics.getCancelledOrdersCount(orders);
        long totalCount = orders.size();
        double cancellationRate = totalCount > 0 ? ((double) cancelledCount / totalCount) * 100 : 0;

        long returnedCount = orders.stream().filter(o -> "RETURNED".equals(o.getStatus())).count();
        double returnRate = totalCount > 0 ? ((double) returnedCount / totalCount) * 100 : 0;

        Map<String, Double> categoryRevenue = ProductInventoryAnalytics.getCategoryWiseRevenue(orders, products);
        Map<Boolean, Double> primeRevenue = CustomerAnalytics.getPrimeVsNonPrimeRevenue(orders);

        System.out.println("=== AMAZON ORDER ANALYTICS DASHBOARD ===");
        System.out.println("Date: " + targetDate);
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println(" EXECUTIVE SUMMARY");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("Total Orders Today: " + ordersToday);
        System.out.println("Total Revenue: ₹" + totalRevenue);
        System.out.println("Average Order Value: ₹" + avgOrderValue);
        System.out.println("Cancellation Rate: " + cancellationRate + "%");
        System.out.println("Return Rate: " + returnRate + "%");

        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("REVENUE ANALYSIS");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("Category-wise Revenue: " + categoryRevenue);
        System.out.println("Prime Revenue: ₹" + primeRevenue.getOrDefault(true, 0.0));
        System.out.println("Non-Prime Revenue: ₹" + primeRevenue.getOrDefault(false, 0.0));

        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("ALERTS & ACTION ITEMS");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("Cross City Fraud Potential Customers: " + AdvancedBusinessIntelligence.detectCrossCityFraud(orders));
        System.out.println("Prime Conversion Opportunities: " + AdvancedBusinessIntelligence.getPrimeConversionOpportunities(orders, targetDate.minusDays(30)));
    }
}
