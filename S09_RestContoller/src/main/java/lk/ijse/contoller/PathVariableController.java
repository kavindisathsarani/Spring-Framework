package lk.ijse.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("variable")
public class PathVariableController {
    @GetMapping(path = "{id:[I][0-9]{3}}")
    //    http://localhost:8080/S09_RestContoller_Web_exploded/variable/I678  - I678 will be in postman result
    public String variable1(@PathVariable("id") String id){
        return id;
    }

    @GetMapping(path = "{customerID}")
//    http://localhost:8080/S09_RestContoller_Web_exploded/variable/67  - 67 will be in postman result
    public String variable2(@PathVariable("customerID") String id){
        return id;
    }


//    /variable/34/kavi
    @GetMapping(path = "{customerID}/{customerName}")
//   http://localhost:8080/S09_RestContoller_Web_exploded/variable/34/kavi - 34 kavi will be in postman result
    public String variable3(@PathVariable("customerID") String id,
                            @PathVariable("customerName") String name){
        return id+" "+name;
    }
}
