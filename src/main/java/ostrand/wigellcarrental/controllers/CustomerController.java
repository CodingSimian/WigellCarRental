package ostrand.wigellcarrental.controllers;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ostrand.wigellcarrental.entities.Customer;
import ostrand.wigellcarrental.services.CustomerServiceImpl;

@RestController
public class CustomerController {
    private static final Logger customerLogger = Logger.getLogger(CustomerController.class);
private final CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/customers")
    public ResponseEntity getAllCustomers(){
        customerLogger.info("Admin viewed all customers");
    return new ResponseEntity(customerService.listCustomers(),HttpStatus.OK);
    }

    @PostMapping("/addcustomer")
    public ResponseEntity addCustomer(@RequestBody Customer customer){
         ResponseEntity respone = customerService.addCustomer(customer);

        // TODO Lägg till logger.fatal() meddelande i AdviceController och ErrorResponse
        customerLogger.info("Admin added customer");
        return respone;
    }


    @PutMapping("/updatecustomer")
    public ResponseEntity updateCustomer(@RequestBody Customer customer){
        Long id = customer.getId();
        customerService.updateCustomerById(id,customer);
        customerLogger.info("Admin updated customer with id of: " + id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

    @DeleteMapping("/deletecustomer")
    public ResponseEntity deleteCustomer(@RequestBody Customer customer){
        Long id = customer.getId();
        customerService.deleteById(id);
        customerLogger.info("Admin deleted customer with id of: " + id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
