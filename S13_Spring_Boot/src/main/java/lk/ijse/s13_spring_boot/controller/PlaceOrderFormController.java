package lk.ijse.s13_spring_boot.controller;


import lk.ijse.s13_spring_boot.dto.OrderDTO;
import lk.ijse.s13_spring_boot.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@CrossOrigin
public class PlaceOrderFormController {

    private final OrderService orderService;

    public PlaceOrderFormController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/place")
    public ResponseEntity<String> placeOrder(@RequestBody OrderDTO orderDTO) {
        String response = orderService.placeOrder(orderDTO);
        return ResponseEntity.ok(response);
    }
}