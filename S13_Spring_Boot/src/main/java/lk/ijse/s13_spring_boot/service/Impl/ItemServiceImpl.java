package lk.ijse.s13_spring_boot.service.Impl;

import lk.ijse.s13_spring_boot.dto.ItemDTO;
import lk.ijse.s13_spring_boot.entity.Item;
import lk.ijse.s13_spring_boot.repo.ItemRepo;
import lk.ijse.s13_spring_boot.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public boolean save(ItemDTO itemDTO){
//        Item item=new Item(itemDTO.getId(),itemDTO.getName(),itemDTO.getPrice(),itemDTO.getQuantity());
        if (itemRepo.existsById(itemDTO.getId())) {
            return false;
        }
        itemRepo.save(modelMapper.map(itemDTO,Item.class));
        return true;
    }
    @Override
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
    @Override
    public int delete(int id){
        itemRepo.deleteById(id);
        return id;
    }
    @Override
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
