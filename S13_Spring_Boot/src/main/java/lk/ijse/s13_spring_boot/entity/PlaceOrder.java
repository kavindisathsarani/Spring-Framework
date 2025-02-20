package lk.ijse.s13_spring_boot.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class PlaceOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany
    @JoinColumn(name = "order_id")
    private List<Item> items;

    private double totalAmount;
    private String orderDate;

    public PlaceOrder() {
    }

    public PlaceOrder(int orderId, Customer customer, List<Item> items, double totalAmount, String orderDate) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = items;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
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

    @Override
    public String toString() {
        return "PlaceOrder{" +
                "orderId=" + orderId +
                ", customer=" + customer +
                ", items=" + items +
                ", totalAmount=" + totalAmount +
                ", orderDate='" + orderDate + '\'' +
                '}';
    }
}
