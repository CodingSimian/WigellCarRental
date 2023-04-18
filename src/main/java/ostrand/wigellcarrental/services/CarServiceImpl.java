package ostrand.wigellcarrental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ostrand.wigellcarrental.custom.exception.BusinessException;
import ostrand.wigellcarrental.entities.Car;
import ostrand.wigellcarrental.repositories.CarRepository;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    private CarRepository repository;
    @Override
    public List<Car> getAllCars() {
        if(repository.count()<1){
            throw new BusinessException("No data available",HttpStatus.NO_CONTENT.value());
        }
       return repository.findAll();
    }

    @Override
    public Car addCar(Car car) {
          return repository.save(car);
    }

    @Override
    public void deleteCar(Car car) {
        System.out.println("kommer hit");
       repository.deleteById(car.getId());
    }



    @Override
    public List<Car> getAllAvailableCars() {
        List<Car> availableCars = repository.findAllByAvailableIsTrue();
        if(availableCars.isEmpty()){
            throw new BusinessException("No data available",HttpStatus.NO_CONTENT.value());
        }
        return availableCars;
    }

    @Override
    public Car updateCar(Car car) {
        System.out.println(car.toString());
       return car = repository.save(car);
    }
}
