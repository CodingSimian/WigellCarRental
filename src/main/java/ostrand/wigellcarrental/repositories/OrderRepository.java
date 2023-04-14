package ostrand.wigellcarrental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ostrand.wigellcarrental.entities.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
