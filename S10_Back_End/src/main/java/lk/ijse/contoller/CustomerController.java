package lk.ijse.contoller;

import lk.ijse.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api/v1/customer")

@CrossOrigin
//To solve the CORS issue this annotation is used
//@CrossOrigin("http//localhost:63342") this means only one origin allows
public class CustomerController {
    ArrayList<CustomerDTO> customerDTOArrayList=new ArrayList<>();

    @PostMapping("save")
    private CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerDTOArrayList.add(customerDTO);
        return customerDTO;
    }
    @PutMapping("update")
    private CustomerDTO updateCustomer(@RequestBody CustomerDTO customerDTO){
        for (int i=0;i<customerDTOArrayList.size();i++){
            CustomerDTO existingCustomer=customerDTOArrayList.get(i);
            if (existingCustomer.getId().equals(customerDTO.getId())){
                existingCustomer.setName(customerDTO.getName());
                existingCustomer.setAddress(customerDTO.getAddress());
                existingCustomer.setAge(customerDTO.getAge());
            }
        }
        return customerDTO;
    }
    @GetMapping("getAll")
    private ArrayList<CustomerDTO> getAllCustomer(){
        return customerDTOArrayList;
    }
    @DeleteMapping(path = "delete/{id}")
    private boolean deleteCustomer(@PathVariable(value = "id") String id){
        for (int i =0;i<customerDTOArrayList.size();i++){
            CustomerDTO existingCustomer=customerDTOArrayList.get(i);
            if (existingCustomer.getId().equals(id)){
                customerDTOArrayList.remove(i);
                return true;
            }
        }
        return false;
    }

}
