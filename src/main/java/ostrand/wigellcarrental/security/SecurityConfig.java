package ostrand.wigellcarrental.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import javax.sql.DataSource;



@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{


    // databas anslutning
    @Autowired
    private DataSource dataSource;


    // Säger åt Spring Security att det finns tabels i databasen enligt Spring securitys spefikationer,
    // där den kan leta efter Users och Authorities med sina standard querries.
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }





    @Override
    protected void configure (HttpSecurity http) throws Exception {

        // Sätter roll begränsningar på endpoints.
        http.authorizeRequests()
                .antMatchers("/cars","/ordercar","/cancelorder","/myorders").hasRole("CUSTOMER")
                .antMatchers("/addcar","/updatecar","/deletecar","/allcars","/orders","/deleteorder",
                        "/customers", "/addcustomer", "/updateCustomer", "/deletecustomer"  ).hasRole("ADMIN");




        // Bara för utveckling skall tas bort ifall programmet skall användas på riktigt
        // Tillåter en att komma åt H2-console utan inloggning
        http.authorizeRequests()
                .antMatchers("/h2-console/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();


        http.headers()
                .frameOptions()
                .sameOrigin();


        // aktiverar Http Basic Authentication
        http.httpBasic();

        // Viktig
        http.csrf().disable();

    }






}
