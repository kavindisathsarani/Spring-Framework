package lk.ijse.s13_spring_boot.service;

import lk.ijse.s13_spring_boot.dto.CustomerDTO;
import lk.ijse.s13_spring_boot.entity.Customer;
import lk.ijse.s13_spring_boot.repo.CustomerRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService{
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;
    public boolean save(CustomerDTO customerDTO){
//        Customer customer=new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getAddress());
        customerRepo.save(modelMapper.map(customerDTO,Customer.class));
        return true;
    }

    public ArrayList<CustomerDTO> getAll() {
        /*List<Customer> customers = customerRepo.findAll();
        ArrayList<CustomerDTO> customerDTOS = new ArrayList<>();

        for (Customer customer : customers) {
            customerDTOS.add(new CustomerDTO(
                    customer.getId(),
                    customer.getName(),
                    customer.getAddress()
            ));
        }*/
       return modelMapper.map(customerRepo.findAll(),new TypeToken<List<CustomerDTO>>(){}.getType());

//        return customerDTOS;
    }
    public int delete(int id){
        customerRepo.deleteById(id);
        return id;
    }
    public boolean update(CustomerDTO customerDTO){
        if(customerRepo.existsById(customerDTO.getId())){
           /* Customer customer=new Customer(
                    customerDTO.getId(),
                    customerDTO.getName(),
                    customerDTO.getAddress()
            );*/
            customerRepo.save(modelMapper.map(customerDTO,Customer.class));
            return true;
        }
        return false;
    }

}
