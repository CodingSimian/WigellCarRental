package ostrand.wigellcarrental.services;


import ostrand.wigellcarrental.entities.Customer;
import ostrand.wigellcarrental.entities.Order;

import java.util.List;

public interface OrderService {

    Order placeOrder(Order order);

    void cancelOrder(Order order);

    List<Order> getAllOrders();

    void deleteOrder(Order order);

    List<Order> getAllCustomerOrders(Customer customer);
}
