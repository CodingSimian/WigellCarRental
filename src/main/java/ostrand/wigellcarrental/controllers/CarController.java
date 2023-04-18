package ostrand.wigellcarrental.controllers;

import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ostrand.wigellcarrental.entities.Car;
import ostrand.wigellcarrental.services.CarServiceImpl;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarServiceImpl carService;

    @GetMapping("/allcars")
    public ResponseEntity<List<Car>> getAllCars(){
        return new ResponseEntity<List<Car>>(carService.getAllCars(), HttpStatus.OK);
    }

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAvaibleCars(){
        return new ResponseEntity<List<Car>>(carService.getAllAvailableCars(),HttpStatus.OK);
    }

    @PutMapping("/updatecar")
    public ResponseEntity<Car> updateCar(@RequestBody Car car){
        return new ResponseEntity<Car>(carService.updateCar(car),HttpStatus.OK);
    }

    @DeleteMapping("/deletecar")
    public ResponseEntity<String> deleteCar(@RequestBody Car car){
        System.out.println(car.toString());
        carService.deleteCar(car);
        return  new ResponseEntity<>("Deleted Car with id:"+car.getId(),HttpStatus.OK);
    }

    @PostMapping("/addcar")
    public ResponseEntity<Car> addCar(@RequestBody Car car){
        return new ResponseEntity<Car>(carService.addCar(car),HttpStatus.OK);
    }

}
