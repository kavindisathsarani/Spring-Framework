package lk.ijse.s13_spring_boot.dto;

import java.util.List;

public class PlaceOrderDTO {
    private int orderId;
    private int customerId;
    private String customerName;
    private List<ItemDTO> items;
    private double totalAmount;
    private String orderDate;

    // Constructors
    public PlaceOrderDTO(int orderId, int customerId, String customerName, List<ItemDTO> items, double totalAmount, String orderDate) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.items = items;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
    }

    // Getters and Setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
