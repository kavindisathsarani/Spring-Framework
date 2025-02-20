package lk.ijse.s13_spring_boot.controller;

import lk.ijse.s13_spring_boot.dto.ItemDTO;
import lk.ijse.s13_spring_boot.service.Impl.ItemServiceImpl;
import lk.ijse.s13_spring_boot.utill.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin

public class ItemController {
    @Autowired
    private ItemServiceImpl itemService;
    @PostMapping(path = "save")
    public ResponseUtil getCustomer(@RequestBody ItemDTO itemDTO) {
        /*boolean res=itemService.save(itemDTO);
        return res;*/
       itemService.save(itemDTO);
       return new ResponseUtil(201,"Item is saved",null);


    }

    @GetMapping(path = "getAll")
    public /*ArrayList<ItemDTO>*/ ResponseUtil getAll(){
//        return itemService.getAll();
        return new ResponseUtil(
                200,
                "success",
                itemService.getAll());
    }
    @DeleteMapping(path = "delete/{id}")
    public ResponseUtil deleteCustomer(@PathVariable(value = "id") int id){
//        return itemService.delete(id);
        itemService.delete(id);
        return new ResponseUtil(200,"Customer is deleted",null);
    }
    @PutMapping(path = "update")
    public ResponseUtil update(@RequestBody ItemDTO itemDTO){
//        return itemService.update(itemDTO);
         itemService.update(itemDTO);
         return new ResponseUtil(200,"item is updated",null);



    }


}
