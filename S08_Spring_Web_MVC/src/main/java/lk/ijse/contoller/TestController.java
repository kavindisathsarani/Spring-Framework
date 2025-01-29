package lk.ijse.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {
//mapping method(handler method)
    @GetMapping
    public String test(){
        return "Test";
    }
}
