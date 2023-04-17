package ostrand.wigellcarrental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ostrand.wigellcarrental.entities.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

}
