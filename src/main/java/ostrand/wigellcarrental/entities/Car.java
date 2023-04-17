package ostrand.wigellcarrental.entities;

import jakarta.persistence.*;

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

}
