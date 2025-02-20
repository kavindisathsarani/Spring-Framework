package lk.ijse.s13_spring_boot.service;

import lk.ijse.s13_spring_boot.dto.ItemDTO;

import java.util.ArrayList;

public interface ItemService {
    void save(ItemDTO itemDTO);
    ArrayList<ItemDTO> getAll();
    void delete(int id);
    void update(ItemDTO itemDTO);
}
