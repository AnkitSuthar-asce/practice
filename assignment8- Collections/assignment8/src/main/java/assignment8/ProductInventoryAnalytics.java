package assignment8;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductInventoryAnalytics {
    public static List<Map.Entry<String, Integer>> getBestSellingProducts(List<Order> orders) {
        return orders.stream()
                .collect(Collectors.groupingBy(Order::getProductId, Collectors.summingInt(Order::getQuantity)))
                .entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .collect(Collectors.toList());
    }

    public static Map<String, Double> getCategoryWiseRevenue(List<Order> orders, List<Product> products) {
        Map<String, String> productCategoryMap = products.stream()
                .collect(Collectors.toMap(Product::getProductId, Product::getCategory));
        return orders.stream()
                .collect(Collectors.groupingBy(o -> productCategoryMap.getOrDefault(o.getProductId(), "Unknown"),
                        Collectors.summingDouble(Order::getOrderAmount)));
    }

    public static List<Product> getLowStockHighSellingProducts(List<Product> products, List<Order> orders) {
        Map<String, Integer> salesMap = orders.stream()
                .collect(Collectors.groupingBy(Order::getProductId, Collectors.summingInt(Order::getQuantity)));
        int medianSales = salesMap.values().stream().mapToInt(Integer::intValue).sum() / Math.max(1, salesMap.size());

        return products.stream()
                .filter(p -> p.getStockQuantity() < 10 && salesMap.getOrDefault(p.getProductId(), 0) > medianSales)
                .collect(Collectors.toList());
    }

    public static List<String> getHighReturnRateProducts(List<Order> orders) {
        Map<String, Long> totalOrders = orders.stream()
                .collect(Collectors.groupingBy(Order::getProductId, Collectors.counting()));
        Map<String, Long> returnedOrders = orders.stream()
                .filter(o -> "RETURNED".equals(o.getStatus()))
                .collect(Collectors.groupingBy(Order::getProductId, Collectors.counting()));

        return totalOrders.keySet().stream()
                .filter(pid -> {
                    long total = totalOrders.get(pid);
                    long returned = returnedOrders.getOrDefault(pid, 0L);
                    return total > 0 && ((double) returned / total) > 0.15;
                })
                .collect(Collectors.toList());
    }

    public static Map<String, Double> getAverageDeliveryTimePerCity(List<Order> orders) {
        return orders.stream()
                .filter(o -> "DELIVERED".equals(o.getStatus()))
                .collect(Collectors.groupingBy(Order::getDeliveryCity,
                        Collectors.averagingDouble(o -> 2.0)));
    }

    public static Map<String, Long> getPaymentModePreference(List<Order> orders) {
        return orders.stream()
                .collect(Collectors.groupingBy(Order::getPaymentMode, Collectors.counting()));
    }
}

