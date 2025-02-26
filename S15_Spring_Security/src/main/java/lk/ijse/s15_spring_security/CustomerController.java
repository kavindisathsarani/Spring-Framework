package lk.ijse.s15_spring_security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    public List<Customer> customers=new ArrayList<Customer>( List.of(new Customer("kavi",2),
            new Customer("sathsarani",3)));


    @GetMapping
    public List<Customer> getCustomers(){return customers; }

    @PostMapping
    public void addCustomer(@RequestBody Customer customer){
        customers.add(customer);
    }

    @GetMapping("csrftoken")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
