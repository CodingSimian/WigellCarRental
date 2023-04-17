package ostrand.wigellcarrental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ostrand.wigellcarrental.entities.Car;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
}
