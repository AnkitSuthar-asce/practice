package assignment8;
import java.time.LocalDateTime;

public class Order {
    private String orderId;
    private String customerId;
    private String productId;
    private int quantity;
    private double orderAmount;
    private LocalDateTime orderDate;
    private String status;
    private String paymentMode;
    private String deliveryCity;
    private boolean isPrime;

    public Order(String orderId, String customerId, String productId, int quantity, double orderAmount, LocalDateTime orderDate, String status, String paymentMode, String deliveryCity, boolean isPrime) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.productId = productId;
        this.quantity = quantity;
        this.orderAmount = orderAmount;
        this.orderDate = orderDate;
        this.status = status;
        this.paymentMode = paymentMode;
        this.deliveryCity = deliveryCity;
        this.isPrime = isPrime;
    }

    public String getOrderId() { return orderId; }
    public String getCustomerId() { return customerId; }
    public String getProductId() { return productId; }
    public int getQuantity() { return quantity; }
    public double getOrderAmount() { return orderAmount; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public String getStatus() { return status; }
    public String getPaymentMode() { return paymentMode; }
    public String getDeliveryCity() { return deliveryCity; }
    public boolean isPrime() { return isPrime; }
}

