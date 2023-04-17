package ostrand.wigellcarrental.entities;

//import jakarta.persistence.*;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(length = 40)
    private String username;

    @Column(length = 60)
    private String name;

    @Column(length = 70)
    private String email;

    @Column(length = 14)
    private Integer phone_nmbr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone_nmbr() {
        return phone_nmbr;
    }

    public void setPhone_nmbr(Integer phone_nmbr) {
        this.phone_nmbr = phone_nmbr;
    }
}
