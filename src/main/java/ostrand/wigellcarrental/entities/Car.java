package ostrand.wigellcarrental.entities;



import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(length = 30,nullable = false)
    private String brand;

    @Column(length = 30,nullable = false)
    private String modell;

    @Column(length = 7,nullable = false)
    private String registrationNumber;

    @Column(nullable = false)
    private boolean available;


    public Car() {
    }

    public Car(Long id, String brand, String modell, String registrationNumber, boolean available) {
        this.id = id;
        this.brand = brand;
        this.modell = modell;
        this.registrationNumber = registrationNumber;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", modell='" + modell + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", available=" + available +
                '}';
    }
}
