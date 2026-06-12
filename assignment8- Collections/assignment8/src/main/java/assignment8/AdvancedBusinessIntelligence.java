package assignment8;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdvancedBusinessIntelligence {
    public static List<String> detectCrossCityFraud(List<Order> orders) {
        return orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomerId,
                        Collectors.groupingBy(o -> o.getOrderDate().toLocalDate(),
                                Collectors.mapping(Order::getDeliveryCity, Collectors.toSet()))))
                .entrySet().stream()
                .filter(e -> e.getValue().values().stream().anyMatch(cities -> cities.size() > 1))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> detectDynamicPricingIssues(List<Product> products, List<Order> orders) {
        Map<String, Integer> salesMap = orders.stream()
                .collect(Collectors.groupingBy(Order::getProductId, Collectors.summingInt(Order::getQuantity)));
        int avgSales = salesMap.values().stream().mapToInt(Integer::intValue).sum() / Math.max(1, salesMap.size());

        return products.stream()
                .filter(p -> p.getRating() < 3.0 && salesMap.getOrDefault(p.getProductId(), 0) > avgSales)
                .map(Product::getProductId)
                .collect(Collectors.toList());
    }

    public static List<String> getOverstockedLowSalesProducts(List<Product> products, List<Order> orders, LocalDate thresholdDate) {
        Map<String, Integer> recentSales = orders.stream()
                .filter(o -> o.getOrderDate().toLocalDate().isAfter(thresholdDate))
                .collect(Collectors.groupingBy(Order::getProductId, Collectors.summingInt(Order::getQuantity)));

        return products.stream()
                .filter(p -> p.getStockQuantity() > 100 && recentSales.getOrDefault(p.getProductId(), 0) < 5)
                .map(Product::getProductId)
                .collect(Collectors.toList());
    }

    public static List<String> getPrimeConversionOpportunities(List<Order> orders, LocalDate thresholdDate) {
        return orders.stream()
                .filter(o -> !o.isPrime() && o.getOrderDate().toLocalDate().isAfter(thresholdDate))
                .collect(Collectors.groupingBy(Order::getCustomerId, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<Map.Entry<String, Double>> rankSellersByRevenue(List<Order> orders, List<Product> products) {
        Map<String, String> productSellerMap = products.stream()
                .collect(Collectors.toMap(Product::getProductId, Product::getSeller));

        return orders.stream()
                .collect(Collectors.groupingBy(o -> productSellerMap.getOrDefault(o.getProductId(), "Unknown"),
                        Collectors.summingDouble(Order::getOrderAmount)))
                .entrySet().stream()
                .sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()))
                .collect(Collectors.toList());
    }

    public static double calculateSeasonalTrend(List<Order> orders, int currentMonth, int previousMonth, int year) {
        double currentMonthSales = orders.stream()
                .filter(o -> o.getOrderDate().getMonthValue() == currentMonth && o.getOrderDate().getYear() == year)
                .mapToDouble(Order::getOrderAmount)
                .sum();

        double previousMonthSales = orders.stream()
                .filter(o -> o.getOrderDate().getMonthValue() == previousMonth && o.getOrderDate().getYear() == year)
                .mapToDouble(Order::getOrderAmount)
                .sum();

        if (previousMonthSales == 0) return currentMonthSales > 0 ? 100.0 : 0.0;
        return ((currentMonthSales - previousMonthSales) / previousMonthSales) * 100;
    }
}
