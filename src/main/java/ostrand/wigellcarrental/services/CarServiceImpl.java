package ostrand.wigellcarrental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ostrand.wigellcarrental.entities.Car;
import ostrand.wigellcarrental.repositories.CarRepository;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    private CarRepository repository;
    @Override
    public ResponseEntity getAllCars() {
        ResponseEntity response;
        List<Car> carList = repository.findAll();
        if(carList.isEmpty()){
            response = new ResponseEntity<>("Not cars found", HttpStatus.NO_CONTENT);
        }else {
            response = new ResponseEntity<>(carList,HttpStatus.OK);
        }
        return response;
    }

    @Override
    public ResponseEntity addCar(Car car) {
        ResponseEntity response;
          try {
              response = new ResponseEntity<>(repository.save(car),HttpStatus.OK);
          }catch (Exception ex){
              response = new ResponseEntity<>(ex.getMessage().substring(0,ex.getMessage().indexOf(':')),HttpStatus.BAD_REQUEST);
          }
          return response;
    }

    @Override
    public ResponseEntity deleteCar(Car car) {
        ResponseEntity response;
        try{
            response = new ResponseEntity<>("Deleted Car with id:" + car.getId(),HttpStatus.OK);
           repository.delete(car);
        }catch (Exception ex){
            response = new ResponseEntity<>(ex.getMessage().substring(0,ex.getMessage().indexOf(':')),HttpStatus.BAD_REQUEST);
        }
        return  response;
    }

    @Override
    public ResponseEntity deleteCar(Long id) {
        ResponseEntity response;
        try{
            response = new ResponseEntity<>("Deleted Car with id:" + id,HttpStatus.OK);
        }catch (Exception ex){
            response = new ResponseEntity<>(ex.getMessage().substring(0,ex.getMessage().indexOf(':')),HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @Override
    public ResponseEntity getAllAvailableCars() {
        ResponseEntity response;
        List<Car> availableCars = repository.findAllByAvailableIsTrue();
        if(availableCars.isEmpty()){
            response = new ResponseEntity<>("No avaible cars",HttpStatus.NO_CONTENT);
        }else {
            response = new ResponseEntity<>(availableCars,HttpStatus.OK);
        }
        return response;
    }

    @Override
    public ResponseEntity updateCar(Car car) {
        ResponseEntity response;
        if(repository.existsById(car.getId())){
            try{
                response = new ResponseEntity<>(repository.save(car),HttpStatus.OK);
            }catch (Exception ex){
                response = new ResponseEntity<>(ex.getMessage().substring(0,ex.getMessage().indexOf(':')),HttpStatus.BAD_REQUEST);
            }
        }else {
            response = new ResponseEntity<>("No car found with id:"+car.getId(),HttpStatus.NOT_FOUND);
        }

        return response;
    }
}
