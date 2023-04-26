package ostrand.wigellcarrental.security;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "authorities")
public class Authorities {

    @Id
    private String userName;

    private String authority;

    public Authorities(String userName, String authority) {
        this.userName = userName;
        this.authority = authority;
    }

    public Authorities() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
