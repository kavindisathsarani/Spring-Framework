package lk.ijse.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("one")

public class WildCardMappingOptionOne {

    //    /one/test/33/hello  -work
//    /one/test//hello    -404 status error
//    d/one/test/sds/hello/sas -404 status error
    @GetMapping(path = "test/*/hello")
    //how to check in postman
    //http://localhost:8080/S09_RestContoller_Web_exploded/one/test/*/hello and send get request
    public String test() {
        return "get mapping option one";
    }

    @GetMapping(path = "test/*/*")
//       /test/djsdjf/sdsdjs - work
//    /test/*/*  -work
//    /test  -404 status error
    public String test2() {

        return "get mapping option one";
    }
}
