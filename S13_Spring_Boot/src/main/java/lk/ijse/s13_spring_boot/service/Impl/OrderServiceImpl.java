package lk.ijse.s13_spring_boot.service.Impl;


import lk.ijse.s13_spring_boot.dto.OrderDTO;
import lk.ijse.s13_spring_boot.dto.OrderDetailDTO;
import lk.ijse.s13_spring_boot.entity.Customer;
import lk.ijse.s13_spring_boot.entity.Item;
import lk.ijse.s13_spring_boot.entity.Order;
import lk.ijse.s13_spring_boot.entity.OrderDetail;
import lk.ijse.s13_spring_boot.repo.CustomerRepo;
import lk.ijse.s13_spring_boot.repo.ItemRepo;
import lk.ijse.s13_spring_boot.repo.OrderDetailRepo;
import lk.ijse.s13_spring_boot.repo.OrderRepo;
import lk.ijse.s13_spring_boot.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final OrderDetailRepo orderDetailRepo;
    private final CustomerRepo customerRepo;
    private final ItemRepo itemRepo;

    public OrderServiceImpl(OrderRepo orderRepo, OrderDetailRepo orderDetailRepo,
                            CustomerRepo customerRepo, ItemRepo itemRepo) {
        this.orderRepo = orderRepo;
        this.orderDetailRepo = orderDetailRepo;
        this.customerRepo = customerRepo;
        this.itemRepo = itemRepo;
    }

    @Override
    public String placeOrder(OrderDTO orderDTO) {
        Optional<Customer> optionalCustomer = customerRepo.findById(orderDTO.getCustomerId());
        if (!optionalCustomer.isPresent()) {
            throw new RuntimeException("Customer not found!");
        }

        Order order = new Order();
        order.setCustomer(optionalCustomer.get());
        order.setOrderDate(LocalDate.now().toString());
        order.setTotalPrice(orderDTO.getTotalPrice());

        List<OrderDetail> orderDetailsList = new ArrayList<>();
        for (OrderDetailDTO detailDTO : orderDTO.getOrderDetails()) {
            Optional<Item> optionalItem = itemRepo.findById(detailDTO.getItemId());
            if (!optionalItem.isPresent()) {
                throw new RuntimeException("Item not found!");
            }

            Item item = optionalItem.get();
            if (item.getQuantity() < detailDTO.getQuantity()) {
                throw new RuntimeException("Not enough stock for item: " + item.getName());
            }

            // Reduce stock
            item.setQuantity(item.getQuantity() - detailDTO.getQuantity());
            itemRepo.save(item);

            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(order);
            orderDetail.setItem(item);
            orderDetail.setQuantity(detailDTO.getQuantity());
            orderDetail.setUnitPrice(detailDTO.getUnitPrice());

            orderDetailsList.add(orderDetail);
        }

        order.setOrderDetails(orderDetailsList);
        orderRepo.save(order);
        orderDetailRepo.saveAll(orderDetailsList);

        return "Order placed successfully!";
    }
}