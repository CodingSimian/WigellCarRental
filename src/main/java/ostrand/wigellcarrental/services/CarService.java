package ostrand.wigellcarrental.services;

import org.springframework.http.ResponseEntity;
import ostrand.wigellcarrental.entities.Car;

import java.util.List;

public interface CarService {

    List<Car> getAllCars();

    Car addCar(Car car);

    void deleteCar(Car car);


    List<Car> getAllAvailableCars();

    Car updateCar(Car car);


}
