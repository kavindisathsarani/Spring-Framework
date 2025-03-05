package lk.ijse.s16_spring_boot_bean_validation.controller;

import jakarta.validation.Valid;
import lk.ijse.s16_spring_boot_bean_validation.dto.CustomerDTO;
import lk.ijse.s16_spring_boot_bean_validation.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    /*send POST request to http://localhost:8080/api/v1/customer/save
    select body-raw then type this then send a request
     {
    "name":"kavi",
    "email":"kavi@gmail.com",
    "phoneNumber":"0777876756"
    }

The below thing wil get printed in the postman.

    {
    "message": "User Created successfully",
    "statusCode": 201,
    "data": {
        "name": "kavi",
        "email": "kavi@gmail.com",
        "phoneNumber": "0777876756"
    }
}
*/

    /*after coding GlobalExceptionHandler class if you send an invalid one the warning will get printed as the blow example.

    send POST request to http://localhost:8080/api/v1/customer/save
    select body-raw then type this then send a request{
    "name":"kavi",
    "email":"kavigmail.com",
    "phoneNumber":"077787676"

}

 the below will get printed in the postman
 {
    "message": "Validation failed",
    "statusCode": 400,
    "data": {
        "phoneNumber": "Phone number must be exactly 10 digits",
        "email": "Invalid email format"
    }
}
 */
    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> createCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        ResponseDTO responseDTO = new ResponseDTO(
                "User Created successfully",
                HttpStatus.CREATED.value(),
                customerDTO
        );
        return new ResponseEntity(responseDTO, HttpStatus.CREATED);
    }

}
