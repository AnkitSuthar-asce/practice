package assignment6;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

class Product {
    private String productId;
    private String name;
    private double price;
    private String category;
    public Product(String productId, String name, double price, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
    }
    public String getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
}
class CartItem {
    public Product product;
    public int quantity;
    public LocalDateTime addedTimestamp;
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.addedTimestamp = LocalDateTime.now();
    }
}


public class ShopCart {
    LinkedHashMap<String, Integer> inventory = new LinkedHashMap<>();
    LinkedHashMap<String, CartItem> cart = new LinkedHashMap<>();
    
    public void addInventory(String productId, int quantity) {
        inventory.put(productId, inventory.getOrDefault(productId, 0) + quantity);
    }
    
    public void showInventory() {
        System.out.println("\n--- Current Inventory Status ---");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println("Product ID: " + entry.getKey() + " | Stock: " + entry.getValue());
        }
        System.out.println("--- --- --- --- --- --- --- ---\n");
    }
    
    public void addToCart(Product product, int quantity) {
        if (quantity <= 0) {
            System.out.println("Error: Quantity must be > 0");
            return;
        }
        String pid = product.getProductId();
        if (!cart.containsKey(pid) && cart.size() >= 50) {
            System.out.println("Error: Cart size limit reached");
            return;
        }
        int currentStock = inventory.getOrDefault(pid, 0);
        if (currentStock >= quantity) {
            inventory.put(pid, currentStock - quantity);
            if (cart.containsKey(pid)) {
                cart.get(pid).quantity += quantity;
            } else {
                cart.put(pid, new CartItem(product, quantity));
            }
        } else {
            System.out.println("Error: Insufficient stock");
        }
    }
    
    public void removeFromCart(Product product, int quantity) {
        String pid = product.getProductId();
        if (cart.containsKey(pid)) {
            CartItem item = cart.get(pid);
            int removeAmount = Math.min(quantity, item.quantity);
            item.quantity -= removeAmount;
            inventory.put(pid, inventory.getOrDefault(pid, 0) + removeAmount);
            if (item.quantity <= 0) {
                cart.remove(pid);
            }
        } else {
            System.out.println("Error: Not in cart");
        }
    }
    
    public void updateCartQuantity(Product product, int newQuantity) {
        if (newQuantity <= 0) {
            removeFromCart(product, Integer.MAX_VALUE);
            return;
        }
        String pid = product.getProductId();
        if (cart.containsKey(pid)) {
            CartItem item = cart.get(pid);
            int diff = newQuantity - item.quantity;
            int currentStock = inventory.getOrDefault(pid, 0);
            if (currentStock >= diff) {
                inventory.put(pid, currentStock - diff);
                item.quantity = newQuantity;
            } else {
                System.out.println("Error: Insufficient stock");
            }
        } else {
            addToCart(product, newQuantity);
        }
    }
    
    public void applyDiscount(double value, boolean isPercentage) {
        double total = 0;
        for (CartItem item : cart.values()) {
            total += item.product.getPrice() * item.quantity;
        }
        double discount = isPercentage ? (total * (value / 100)) : value;
        double finalPrice = Math.max(0, total - discount);
        System.out.println("Total: ₹" + total + " | Final: ₹" + finalPrice);
    }
    
    public String saveCartJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ \"cart\": [");
        int count = 0;
        for (CartItem item : cart.values()) {
            sb.append(String.format("{\"id\":\"%s\",\"qty\":%d}", item.product.getProductId(), item.quantity));
            if (++count < cart.size()) sb.append(",");
        }
        sb.append("] }");
        return sb.toString();
    }
    
    public void displayCart() {
        double total = 0;
        for (CartItem item : cart.values()) {
            double sub = item.product.getPrice() * item.quantity;
            total += sub;
            System.out.println(item.product.getName() + " x" + item.quantity + " - ₹" + sub);
        }
        System.out.println("Total: ₹" + total);
    }
    
    public static void main(String[] args) {
    	ShopCart shop = new ShopCart();
        Product p1 = new Product("E01", "Laptop", 60000, "Electronics");
        Product p2 = new Product("E02", "Phone", 30000, "Electronics");
        Product p3 = new Product("F01", "Bread", 40, "Food");
        Product p4 = new Product("F02", "Milk", 60, "Food");
        Product p5 = new Product("F03", "Apple", 20, "Food");
        Product p6 = new Product("C01", "Shirt", 1500, "Clothing");
        Product p7 = new Product("C02", "Jeans", 2500, "Clothing");
        shop.addInventory("E01", 5); shop.addInventory("E02", 10);
        shop.addInventory("F01", 50); shop.addInventory("F02", 20); shop.addInventory("F03", 100);
        shop.addInventory("C01", 15); shop.addInventory("C02", 10);
        shop.showInventory();
        System.out.println("TEST 1: Standard Add & Duplicate Add");
        shop.addToCart(p1, 1);
        shop.addToCart(p1, 1);
        shop.displayCart();
        System.out.println("\nTEST 2: Remove Partial & Remove All");
        shop.addToCart(p3, 10);
        shop.removeFromCart(p3, 5);
        shop.removeFromCart(p1, 2);
        shop.displayCart();
        System.out.println("\nTEST 3: Update Quantity (Increase & Decrease)");
        shop.addToCart(p2, 2);
        shop.updateCartQuantity(p2, 5);
        shop.updateCartQuantity(p2, 1);
        shop.displayCart();
        System.out.println("\nTEST 4: Stock Validation & Negative Quantity");
        shop.addToCart(p7, 50);
        shop.addToCart(p6, -5);
        System.out.println("\nTEST 5: Discounts (Percentage & Fixed)");
        shop.applyDiscount(10, true);
        shop.applyDiscount(100, false);
        System.out.println("\nTEST 6: JSON Serialization");
        System.out.println(shop.saveCartJSON());
    }
}

