package lk.ijse.s13_spring_boot.service;

import lk.ijse.s13_spring_boot.dto.ItemDTO;

import java.util.ArrayList;

public interface ItemService {
    boolean save(ItemDTO itemDTO);
    ArrayList<ItemDTO> getAll();
    int delete(int id);
    boolean update(ItemDTO itemDTO);
}
