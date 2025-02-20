package lk.ijse.s13_spring_boot.service;

import lk.ijse.s13_spring_boot.dto.CustomerDTO;

import java.util.ArrayList;
import java.util.List;

public interface CustomerService {
    boolean save(CustomerDTO customerDTO);
    List<CustomerDTO> getAll();
    int delete(int id);

    boolean update(CustomerDTO customerDTO);
}
