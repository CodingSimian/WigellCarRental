package ostrand.wigellcarrental.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ostrand.wigellcarrental.entities.Customer;
import ostrand.wigellcarrental.services.CustomerServiceImpl;

import java.util.List;

@RestController
public class CustomerController {
private final CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/customers")
    public ResponseEntity getAllCustomers(){

    return new ResponseEntity(customerService.listCustomers(),HttpStatus.OK);
    }

    @PostMapping("/addcustomer")
    public ResponseEntity addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
        //Kanske lägg till custom header här

        return new ResponseEntity(HttpStatus.CREATED);
    }


    @PutMapping("/updatecustomer")
    public ResponseEntity updateCustomer(@RequestBody Customer customer){
        Long id = customer.getId();
        customerService.updateCustomerById(id,customer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

    @DeleteMapping("/deletecustomer")
    public ResponseEntity deleteCustomer(@RequestBody Customer customer){
        Long id = customer.getId();
        customerService.deleteById(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
