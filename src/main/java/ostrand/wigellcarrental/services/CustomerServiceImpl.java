package ostrand.wigellcarrental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ostrand.wigellcarrental.entities.Customer;
import ostrand.wigellcarrental.repositories.CustomerRepository;
import ostrand.wigellcarrental.security.AuthoritiesServiceImpl;
import ostrand.wigellcarrental.security.UserServiceImpl;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private AuthoritiesServiceImpl authoritiesService;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void deleteById(Long id) {
    customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> listCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void updateCustomerById(Long id, Customer customerToBeUpdated) {
    Customer exisisting = customerRepository.findById(id).get();

        exisisting.setEmail(customerToBeUpdated.getEmail());
        exisisting.setName(customerToBeUpdated.getName());
        exisisting.setUsername(customerToBeUpdated.getUsername());
        exisisting.setPhone_nmbr(customerToBeUpdated.getPhone_nmbr());

        customerRepository.save(exisisting); //save ärvs av Crudrepository interfacet, vilket då innebär att
        //om objektets id inte finns i repositoriet så skapas ett nytt objekt, och om det redan finns så uppdateras
        //bara det redan existerande objektet
    }

    @Override
    public ResponseEntity<String> addCustomer(Customer customerToBeAdded) {
        customerRepository.save(customerToBeAdded);
        String password = userService.addNewUser(customerToBeAdded);
        authoritiesService.addAuthority(customerToBeAdded.getUsername());

        return new ResponseEntity<>("Customer added,  username:"+ customerToBeAdded.getUsername() +"  Password:" + password + " Please save in a safe location", HttpStatus.CREATED);
    }
}
