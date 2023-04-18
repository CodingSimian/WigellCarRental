package ostrand.wigellcarrental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ostrand.wigellcarrental.entities.Customer;
import ostrand.wigellcarrental.entities.Order;
import ostrand.wigellcarrental.repositories.OrderRepository;

import java.util.List;


@Service
public class OrderServiceImpl implements OrderService{


    @Autowired
    private OrderRepository repository;

    @Override
    public Order placeOrder(Order order) {
      return repository.save(order);
    }

    @Override
    public void cancelOrder(Order order) {
        order.setActive(false);
        repository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    @Override
    public void deleteOrder(Order order) {
        repository.delete(order);
    }

    @Override
    public List<Order> getAllCustomerOrders(Customer customer) {
       return repository.findAllByCustomer_Id(customer.getId());
    }
}
