package ostrand.wigellcarrental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ostrand.wigellcarrental.custom.exception.BusinessException;
import ostrand.wigellcarrental.entities.Car;
import ostrand.wigellcarrental.entities.Order;
import ostrand.wigellcarrental.repositories.CarRepository;
import ostrand.wigellcarrental.repositories.OrderRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private OrderRepository orderRepository;
    @Override
    public List<Car> getAllCars() {
        if(carRepository.count()<1){
            throw new BusinessException("No data available",HttpStatus.NO_CONTENT.value());
        }
       return carRepository.findAll();
    }

    @Override
    public Car addCar(Car car) {
          return carRepository.save(car);
    }

    @Override
    public void deleteCar(Car car) {
       List<Order>  connectedOrders = orderRepository.findAllByCar_Id(car.getId());
       for(Order order:connectedOrders){
           order.setCar(null);
           order.setActive(false);
        }
       orderRepository.saveAll(connectedOrders);
       carRepository.deleteById(car.getId());
    }



    @Override
    public List<Car> getAllAvailableCars() {
        List<Car> availableCars = carRepository.findAllByAvailableIsTrue();
        if(availableCars.isEmpty()){
            throw new BusinessException("No data available",HttpStatus.NO_CONTENT.value());
        }
        return availableCars;
    }

    @Override
    public Car updateCar(Car car) {
        Optional<Car> databaseCar = carRepository.findById(car.getId());
        if(databaseCar.isEmpty()){
            throw new NoSuchElementException();
        }
       return car = carRepository.save(car);
    }
}
