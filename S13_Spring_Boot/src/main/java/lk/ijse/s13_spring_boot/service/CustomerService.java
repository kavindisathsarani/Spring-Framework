package lk.ijse.s13_spring_boot.service;

import lk.ijse.s13_spring_boot.dto.CustomerDTO;

import java.util.ArrayList;
import java.util.List;

public interface CustomerService {
    void save(CustomerDTO customerDTO);
    List<CustomerDTO> getAll();
    void delete(int id);

    void update(CustomerDTO customerDTO);
}
