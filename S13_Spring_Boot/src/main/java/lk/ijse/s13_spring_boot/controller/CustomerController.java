package lk.ijse.s13_spring_boot.controller;

import lk.ijse.s13_spring_boot.dto.CustomerDTO;
import lk.ijse.s13_spring_boot.service.Impl.CustomerServiceImpl;
import lk.ijse.s13_spring_boot.utill.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/customer")
@CrossOrigin

public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;

    @PostMapping(path = "save")
    public ResponseUtil getCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.save(customerDTO);
        return new ResponseUtil(201, "customer is saved", null);
    }

    @GetMapping(path = "getAll")
    public /*List<CustomerDTO>*/ ResponseUtil getAll() {
        return new ResponseUtil(
                200,
                "success",
                customerService.getAll());
//         return customerService.getAll();

    }

    @DeleteMapping(path = "delete/{id}")
    public ResponseUtil deleteCustomer(@PathVariable(value = "id") int id) {
        customerService.delete(id);
        return new ResponseUtil(200, "Customer is deleted", null);
    }

    @PutMapping(path = "update")
    public ResponseUtil update(@RequestBody CustomerDTO customerDTO) {
        customerService.update(customerDTO);
        return new ResponseUtil(200, "Customer is updated", null);

    }


}
