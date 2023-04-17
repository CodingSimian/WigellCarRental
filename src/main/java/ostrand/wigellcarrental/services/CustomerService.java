package ostrand.wigellcarrental.services;

import ostrand.wigellcarrental.entities.Customer;

import java.util.List;

public interface CustomerService {
    //Interface ska ge funktionalitet för att: Lista, lägga till, uppdatera och ta bort kunder

    public void deleteById(Long id);

    public List<Customer> listCustomers();

    public void updateCustomerById(Long id, Customer customerToBeUpdated);

    public Customer addCustomer(Customer customerToBeAdded);
}
