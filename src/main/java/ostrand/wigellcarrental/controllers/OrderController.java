package ostrand.wigellcarrental.controllers;

import org.apache.log4j.Logger;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ostrand.wigellcarrental.entities.Customer;
import ostrand.wigellcarrental.entities.Order;
import ostrand.wigellcarrental.services.OrderService;

import java.util.List;

@RestController
public class OrderController {

    private static final Logger orderLogger = Logger.getLogger(CustomerController.class);

    @Autowired
    OrderService orderService;

    @PostMapping("/ordercar")
    public ResponseEntity<Order> orderCar(@RequestBody Order order){
        orderLogger.info("Customer ordered car");
        return new ResponseEntity<Order>(orderService.placeOrder(order), HttpStatus.OK);
    }
    @PutMapping("/cancelorder")
    public ResponseEntity<String> cancelOrder(@RequestBody Order order){
        orderService.cancelOrder(order);
        orderLogger.info("Customer cancelled order");
        return new ResponseEntity<String>("Order canceled",HttpStatus.OK);
    }
    @GetMapping("/myorders")
    public ResponseEntity<List<Order>> getCustomerOrders(@RequestBody Customer customer){
        orderLogger.info("Customer with id of: " + customer.getId() + " viewed their order");
        return new ResponseEntity<List<Order>>(orderService.getAllCustomerOrders(customer),HttpStatus.OK);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders(){
        orderLogger.info("Admin viewed all orders");
        return new ResponseEntity<List<Order>>(orderService.getAllOrders(),HttpStatus.OK);
    }

    @DeleteMapping("/deleteorder")
    public ResponseEntity<String> deleteOrder(@RequestBody Order order){
        orderService.deleteOrder(order);
        orderLogger.info("Admin deleted order");
        return new ResponseEntity<String>("Deleted order id:"+ order.getId(),HttpStatus.OK);
    }

}
