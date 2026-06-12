package assignment8;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class OrderAnalytics {
    public static long getOrdersPlacedToday(List<Order> orders, LocalDate today) {
        return orders.stream()
                .filter(o -> o.getOrderDate().toLocalDate().isEqual(today))
                .count();
    }

    public static double getTotalRevenue(List<Order> orders) {
        return orders.stream()
                .filter(o -> "DELIVERED".equals(o.getStatus()))
                .mapToDouble(Order::getOrderAmount)
                .sum();
    }

    public static List<Order> getPendingOrders(List<Order> orders) {
        return orders.stream()
                .filter(o -> "PLACED".equals(o.getStatus()))
                .collect(Collectors.toList());
    }

    public static List<Order> getHighValueOrders(List<Order> orders, double threshold) {
        return orders.stream()
                .filter(o -> o.getOrderAmount() > threshold)
                .collect(Collectors.toList());
    }

    public static long getCancelledOrdersCount(List<Order> orders) {
        return orders.stream()
                .filter(o -> "CANCELLED".equals(o.getStatus()))
                .count();
    }

    public static double getAverageOrderValue(List<Order> orders) {
        return orders.stream()
                .mapToDouble(Order::getOrderAmount)
                .average()
                .orElse(0.0);
    }
}
