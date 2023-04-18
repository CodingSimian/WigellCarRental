package ostrand.wigellcarrental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ostrand.wigellcarrental.entities.Customer;
import ostrand.wigellcarrental.entities.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    List<Order> findAllByCustomer_Id(Long id);

}
