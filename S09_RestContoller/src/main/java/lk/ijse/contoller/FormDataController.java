package lk.ijse.contoller;

import lk.ijse.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("form")
public class FormDataController {
  /*  @PostMapping
//    http://localhost:8080/S09_RestContoller_Web_exploded/form
    //choose in body bar x-www-form-urlencoded then type id then 22 then name and saman postman will show 22:saman
    public  String test1(@RequestParam(value = "id") String id,
                         @RequestParam(value = "name") String name){
        return id+" : "+name;
    }*/

    @PostMapping
    public String test1(@ModelAttribute CustomerDTO customerDTO) {
        System.out.println(customerDTO.getFirstName());
        return customerDTO.toString();
    }
}
