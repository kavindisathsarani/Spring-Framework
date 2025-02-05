package lk.ijse.contoller;

import lk.ijse.dto.CustomerDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("json")
public class JSONController {
    @PostMapping
    public String test1(@RequestBody CustomerDTO customerDTO) {
        return customerDTO.getFirstName();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDTO test2(){
        return new CustomerDTO("kavindi","sathsarani",20);
    }

    @GetMapping(path = "data",produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<CustomerDTO> test3(){
        /*{
        "firstName": "amal",
        "lastname": "nishan",
        "age": 10
    },
    {
        "firstName": "nimal",
        "lastname": "hettigoda",
        "age": 20
    },
    {
        "firstName": "shrimal",
        "lastname": "nishan",
        "age": 13
    } will be shown inpostman*/

        ArrayList<CustomerDTO> customerDTOS=new ArrayList<>();
        customerDTOS.add(new CustomerDTO("amal","nishan",10));
        customerDTOS.add(new CustomerDTO("saman","kumara",20));
        customerDTOS.add(new CustomerDTO("don","nishan",13));
        return customerDTOS;
    }
}
