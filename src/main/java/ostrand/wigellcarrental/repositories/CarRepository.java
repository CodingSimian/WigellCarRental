package ostrand.wigellcarrental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ostrand.wigellcarrental.entities.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {

   List<Car> findAllByAvailableIsTrue();
}
