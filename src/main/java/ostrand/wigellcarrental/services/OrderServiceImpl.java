package ostrand.wigellcarrental.services;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ostrand.wigellcarrental.custom.exception.BusinessException;
import ostrand.wigellcarrental.entities.Car;
import ostrand.wigellcarrental.entities.Customer;
import ostrand.wigellcarrental.entities.Order;
import ostrand.wigellcarrental.repositories.CarRepository;

import ostrand.wigellcarrental.repositories.OrderRepository;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class OrderServiceImpl implements OrderService{



    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CarRepository carRepository;


    @Override
    public Order placeOrder(Order order) {
        order.setDateOfBooking(LocalDate.now());
        validateOrder(order);
      return orderRepository.save(order);
    }

    @Override
    public void cancelOrder(Order order) {
        Order dataBaseOrder = orderRepository.getOne(order.getId());
        dataBaseOrder.getCar().setAvailable(true);
        dataBaseOrder.setActive(false);
        orderRepository.save(dataBaseOrder);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public void deleteOrder(Order order) {
        orderRepository.deleteById(order.getId());
    }

    @Override
    public List<Order> getAllCustomerOrders(Customer customer) {
       return orderRepository.findAllByCustomer_Id(customer.getId());
    }

    private void validateOrder(Order order){
        Optional<Car> databaseCar = carRepository.findById(order.getCar().getId());
        Car orderCar;
        if(databaseCar.isPresent()){
            orderCar = databaseCar.get();
        }else{
            throw new BusinessException("Order contains a car with an invalid id:" +order.getId(),HttpStatus.NOT_FOUND.value());
        }

        if(!orderCar.isAvailable()){
            throw new BusinessException("Car is not available for rent", HttpStatus.OK.value());
        }

        if(orderCar.isAvailable()){
            orderCar.setAvailable(false);
            carRepository.save(orderCar);
        }
    }
}
