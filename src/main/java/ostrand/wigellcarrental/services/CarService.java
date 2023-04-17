package ostrand.wigellcarrental.services;

import org.springframework.http.ResponseEntity;
import ostrand.wigellcarrental.entities.Car;

public interface CarService {

    ResponseEntity getAllCars();

    ResponseEntity addCar(Car car);

    ResponseEntity deleteCar(Car car);
    ResponseEntity deleteCar(Long id);

    ResponseEntity getAllAvailableCars();

    ResponseEntity updateCar(Car car);
}
