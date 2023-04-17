package ostrand.wigellcarrental.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ostrand.wigellcarrental.entities.Car;
import ostrand.wigellcarrental.services.CarServiceImpl;

@RestController
public class CarController {

    @Autowired
    private CarServiceImpl carService;

    @GetMapping("/allcars")
    public ResponseEntity getAllCars(){
        return carService.getAllCars();
    }

    @GetMapping("/cars")
    public ResponseEntity getAvaibleCars(){
        return carService.getAllAvailableCars();
    }

    @PutMapping("/updatecar")
    public ResponseEntity updateCar(@RequestBody Car car){
        return carService.updateCar(car);
    }

    @DeleteMapping("/deleteCar")
    public ResponseEntity deleteCar(@RequestBody Car car){
        return  carService.deleteCar(car);
    }
    @DeleteMapping("/deleteCar")
    public ResponseEntity deleteCar(@RequestBody Long id){
        return carService.deleteCar(id);
    }
}
