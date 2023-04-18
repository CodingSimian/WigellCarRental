package ostrand.wigellcarrental.controllers;

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

    @Autowired
    OrderService orderService;

    @PostMapping("/ordercar")
    public ResponseEntity<Order> orderCar(@RequestBody Order order){
        return new ResponseEntity<Order>(orderService.placeOrder(order), HttpStatus.OK);
    }
    @PutMapping("/cancelorder")
    public ResponseEntity<String> cancelOrder(@RequestBody Order order){
        orderService.cancelOrder(order);
        return new ResponseEntity<String>("Order canceled",HttpStatus.OK);
    }
    @GetMapping("/myorders")
    public ResponseEntity<List<Order>> getCustomerOrders(@RequestBody Customer customer){
        return new ResponseEntity<List<Order>>(orderService.getAllCustomerOrders(customer),HttpStatus.OK);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders(){
        return new ResponseEntity<List<Order>>(orderService.getAllOrders(),HttpStatus.OK);
    }

    @DeleteMapping("/deleteorder")
    public ResponseEntity<String> deleteOrder(@RequestBody Order order){
        orderService.deleteOrder(order);
        return new ResponseEntity<String>("Deleted order id:"+ order.getId(),HttpStatus.OK);
    }

}
