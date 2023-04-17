package ostrand.wigellcarrental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ostrand.wigellcarrental.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
