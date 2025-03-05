package lk.ijse.s17_spring_boot_loggins.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/demo")
public class DemoController {

    /*
    send GET request to http://localhost:8080/api/v1/demo/log-demo and the terminal will print below in the postman,
    Hello World
    */

    //Trace,Debug,Info,Warn,Error are logging levels
    private static final Logger log = LoggerFactory.getLogger(DemoController.class);
    @GetMapping("/log-demo")
    public String logDemo(){
        log.trace("Trace Message");
        log.debug("Debug Message");
        log.info("Info Message");
        log.warn("Warn Message");
        log.error("Error Message");
        return "Hello World";
    }
}
