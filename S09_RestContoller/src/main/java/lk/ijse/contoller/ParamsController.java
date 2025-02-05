package lk.ijse.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("params")
public class ParamsController {
    @GetMapping(params = {"id","name"})
//    http://localhost:8080/S09_RestContoller_Web_exploded/params?id=276&name=kavi  - 276 : kavi will get printed
    public String test1(@RequestParam(value = "id") String id,
                        @RequestParam(value = "name") String name){
        return id+" : "+name;
    }
}
