package lk.ijse.s13_spring_boot.service;

import lk.ijse.s13_spring_boot.dto.CustomerDTO;
import lk.ijse.s13_spring_boot.dto.ItemDTO;
import lk.ijse.s13_spring_boot.entity.Customer;
import lk.ijse.s13_spring_boot.entity.Item;
import lk.ijse.s13_spring_boot.repo.CustomerRepo;
import lk.ijse.s13_spring_boot.repo.ItemRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;
    public boolean save(ItemDTO itemDTO){
//        Item item=new Item(itemDTO.getId(),itemDTO.getName(),itemDTO.getPrice(),itemDTO.getQuantity());
        itemRepo.save(modelMapper.map(itemDTO,Item.class));
        return true;
    }

    public ArrayList<ItemDTO> getAll() {
//        List<Item> items = itemRepo.findAll();
//        ArrayList<ItemDTO> itemDTOS = new ArrayList<>();
//
//        for (Item item : items) {
//            itemDTOS.add(new ItemDTO(
//                    item.getId(),
//                    item.getName(),
//                    item.getPrice(),
//                    item.getQuantity()
//            ));
//        }
//
//        return itemDTOS;

        return modelMapper.map(itemRepo.findAll(),new TypeToken<List<ItemDTO>>(){}.getType());
    }
    public int delete(int id){
        itemRepo.deleteById(id);
        return id;
    }
    public boolean update(ItemDTO itemDTO){
        if(itemRepo.existsById(itemDTO.getId())){
           /* Item item=new Item(
                    itemDTO.getId(),
                    itemDTO.getName(),
                    itemDTO.getPrice(),
                    itemDTO.getQuantity()
            );*/
            itemRepo.save(modelMapper.map(itemDTO,Item.class));
            return true;
        }
        return false;
    }

}
