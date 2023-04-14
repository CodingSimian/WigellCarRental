package ostrand.wigellcarrental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ostrand.wigellcarrental.entities.Car;

public interface CarRepository extends JpaRepository<Car,Long> {
}
