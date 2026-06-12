package assignment8;
import java.time.LocalDateTime;

public class Product {
    private String productId;
    private String productName;
    private String category;
    private double price;
    private int stockQuantity;
    private String seller;
    private double rating;

    public Product(String productId, String productName, String category, double price, int stockQuantity, String seller, double rating) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.seller = seller;
        this.rating = rating;
    }

    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }
    public String getSeller() { return seller; }
    public double getRating() { return rating; }
}

