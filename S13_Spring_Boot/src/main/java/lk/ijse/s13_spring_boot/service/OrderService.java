package lk.ijse.s13_spring_boot.service;


import lk.ijse.s13_spring_boot.dto.OrderDTO;

public interface OrderService {
    String placeOrder(OrderDTO orderDTO);
}