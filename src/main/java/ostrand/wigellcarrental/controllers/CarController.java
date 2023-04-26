package ostrand.wigellcarrental.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ostrand.wigellcarrental.entities.Car;
import ostrand.wigellcarrental.services.CarServiceImpl;

import java.util.List;

@RestController
public class CarController {

    private static final Logger carLogger = Logger.getLogger(CustomerController.class);

    @Autowired
    private CarServiceImpl carService;

    @GetMapping("/allcars")
    public ResponseEntity<List<Car>> getAllCars(){
        carLogger.info("Admin viewed all cars");

        return new ResponseEntity<List<Car>>(carService.getAllCars(), HttpStatus.OK);
    }

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAvailableCars(){
        carLogger.info("Customer viewed all available cars");
        return new ResponseEntity<List<Car>>(carService.getAllAvailableCars(),HttpStatus.OK);
    }

    @PutMapping("/updatecar")
    public ResponseEntity<Car> updateCar(@RequestBody Car car){
        carLogger.info("Admin updated car with id of: " + car.getId());
        return new ResponseEntity<Car>(carService.updateCar(car),HttpStatus.OK);
    }

    @DeleteMapping("/deletecar")
    public ResponseEntity<String> deleteCar(@RequestBody Car car){
        carService.deleteCar(car);
        carLogger.info("Admin deleted car with id of: " + car.getId());
        return  new ResponseEntity<>("Deleted Car with id:"+car.getId(),HttpStatus.OK);
    }

    @PostMapping("/addcar")
    public ResponseEntity<Car> addCar(@RequestBody Car car){
        carLogger.info("Admin added a " + car.getBrand() + " with a id of: " + car.getId());
        return new ResponseEntity<Car>(carService.addCar(car),HttpStatus.OK);
    }

}