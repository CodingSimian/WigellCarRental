package ostrand.wigellcarrental.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private LocalDate dateOfBooking;

    @Column(nullable = false)
    private boolean active;

    @OneToOne(cascade = CascadeType.MERGE)
    private Car car;

    @ManyToOne
    private Customer customer;



    public Order() {
    }

    public Order(Long id, LocalDate dateOfBooking, boolean active, Customer customer, Car car) {
        this.id = id;
        this.dateOfBooking = dateOfBooking;
        this.active = active;
        this.customer = customer;
        this.car = car;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateOfBooking() {
        return dateOfBooking;
    }

    public void setDateOfBooking(LocalDate date) {
        this.dateOfBooking = date;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
