package assignment8;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomerAnalytics {
    public static List<Map.Entry<String, Double>> getTopCustomers(List<Order> orders, int limit) {
        return orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomerId, Collectors.summingDouble(Order::getOrderAmount)))
                .entrySet().stream()
                .sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()))
                .limit(limit)
                .collect(Collectors.toList());
    }

    public static Map<Boolean, Double> getPrimeVsNonPrimeRevenue(List<Order> orders) {
        return orders.stream()
                .collect(Collectors.groupingBy(Order::isPrime, Collectors.summingDouble(Order::getOrderAmount)));
    }

    public static List<String> getPotentialFraudCustomers(List<Order> orders) {
        return orders.stream()
                .filter(o -> "RETURNED".equals(o.getStatus()))
                .collect(Collectors.groupingBy(Order::getCustomerId, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static Map<String, Long> getCityWiseOrderDistribution(List<Order> orders) {
        return orders.stream()
                .collect(Collectors.groupingBy(Order::getDeliveryCity, Collectors.counting()));
    }

    public static Map<String, Long> getCustomerLifetimeValue(List<Order> orders) {
        return orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomerId, Collectors.counting()));
    }

    public static List<String> getInactiveCustomers(List<Customer> customers, List<Order> orders, LocalDate thresholdDate) {
        Map<String, LocalDate> lastOrderDates = orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomerId,
                        Collectors.mapping(o -> o.getOrderDate().toLocalDate(),
                                Collectors.maxBy(LocalDate::compareTo))))
                .entrySet().stream()
                .filter(e -> e.getValue().isPresent())
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().get()));

        return customers.stream()
                .filter(c -> {
                    LocalDate lastDate = lastOrderDates.get(c.getCustomerId());
                    return lastDate == null || lastDate.isBefore(thresholdDate);
                })
                .map(Customer::getCustomerId)
                .collect(Collectors.toList());
    }
}
