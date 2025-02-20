package lk.ijse.s13_spring_boot.controller;

import lk.ijse.s13_spring_boot.dto.CustomerDTO;
import lk.ijse.s13_spring_boot.dto.ItemDTO;
import lk.ijse.s13_spring_boot.service.CustomerService;
import lk.ijse.s13_spring_boot.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin

public class ItemController {
    @Autowired
    private ItemService itemService;
    @PostMapping(path = "save")
    public boolean getCustomer(@RequestBody ItemDTO itemDTO) {
        boolean res=itemService.save(itemDTO);
        return res;
    }

    @GetMapping(path = "getAll")
    public ArrayList<ItemDTO> getAll(){
        return itemService.getAll();

    }
    @DeleteMapping(path = "delete/{id}")
    public int deleteCustomer(@PathVariable(value = "id") int id){
        return itemService.delete(id);
    }
    @PutMapping(path = "update")
    public boolean update(@RequestBody ItemDTO itemDTO){
        return itemService.update(itemDTO);

    }


}
