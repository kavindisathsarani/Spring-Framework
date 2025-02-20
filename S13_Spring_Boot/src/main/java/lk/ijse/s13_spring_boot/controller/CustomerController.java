package lk.ijse.s13_spring_boot.controller;

import lk.ijse.s13_spring_boot.dto.CustomerDTO;
import lk.ijse.s13_spring_boot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin

public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping(path = "save")
    public boolean getCustomer(@RequestBody CustomerDTO customerDTO) {
        boolean res=customerService.save(customerDTO);
        return res;
    }

    @GetMapping(path = "getAll")
    public ArrayList<CustomerDTO> getAll(){
        return customerService.getAll();

    }
    @DeleteMapping(path = "delete/{id}")
    public int deleteCustomer(@PathVariable(value = "id") int id){
        return customerService.delete(id);
    }
    @PutMapping(path = "update")
    public boolean update(@RequestBody CustomerDTO customerDTO){
        return customerService.update(customerDTO);

    }


}
