package ostrand.wigellcarrental.security;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ostrand.wigellcarrental.entities.Customer;

import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    private static final Logger userLogger = Logger.getLogger(UserServiceImpl.class);


    private final  PasswordEncoder BCRYPTPASSWORDENCODER = new BCryptPasswordEncoder();

    private final Random random = new Random();
    @Override
    public String addNewUser(Customer customer) {
        String encoding = "{bcrypt}";
        String password = "Pass"+ (random.nextInt(8888)+1111);
        User user = new User();
        user.setUserName(customer.getUsername());
        user.setPassword(encoding + BCRYPTPASSWORDENCODER.encode(password));
        user.setEnabled(true);
        userRepository.save(user);
        userLogger.info("New User account created for Customer:" + customer.getUsername());
        return password;

    }
}
