package ostrand.wigellcarrental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ostrand.wigellcarrental.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
