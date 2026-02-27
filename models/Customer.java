package models;

public class Customer {

    private String name;
    private String phoneNumber;
    private String location;
    private Order order;

    public Customer(String name, String phoneNumber, String location, Order order) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.order = order;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }

    
    
}
