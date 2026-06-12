package assignment8;
import java.time.LocalDate;

public class Customer {
    private String customerId;
    private String name;
    private String email;
    private String phoneNumber;
    private String city;
    private boolean isPrimeMember;
    private LocalDate registrationDate;

    public Customer(String customerId, String name, String email, String phoneNumber, String city, boolean isPrimeMember, LocalDate registrationDate) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.isPrimeMember = isPrimeMember;
        this.registrationDate = registrationDate;
    }

    public String getCustomerId() { return customerId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getCity() { return city; }
    public boolean isPrimeMember() { return isPrimeMember; }
    public LocalDate getRegistrationDate() { return registrationDate; }
}

