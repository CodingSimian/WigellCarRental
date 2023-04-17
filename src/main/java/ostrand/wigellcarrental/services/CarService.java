package ostrand.wigellcarrental.services;

import org.springframework.http.ResponseEntity;
import ostrand.wigellcarrental.entities.Car;

public interface CarService {

    ResponseEntity getAllCars();

    void addCar(Car car);

    ResponseEntity deleteCar(Car car);

    ResponseEntity deleteCarById(int id);


}
