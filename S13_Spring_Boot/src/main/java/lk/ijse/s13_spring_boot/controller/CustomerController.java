package lk.ijse.s13_spring_boot.controller;

import lk.ijse.s13_spring_boot.dto.CustomerDTO;
import lk.ijse.s13_spring_boot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping(path = "save")
    public boolean getCustomer(@RequestBody CustomerDTO customerDTO) {
        boolean res=customerService.save(customerDTO);
        return res;
    }

}
