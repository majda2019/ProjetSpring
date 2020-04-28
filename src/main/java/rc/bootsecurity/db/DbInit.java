package rc.bootsecurity.db;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import rc.bootsecurity.entity.User;
import rc.bootsecurity.repository.UserRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        // Delete all
        this.userRepository.deleteAll();

        // Crete users
        User user = new User("user",passwordEncoder.encode("user123"),"USER","");
        User admin = new User("admin",passwordEncoder.encode("admin123"),"ADMIN","");
      //  User prof = new User("prof",passwordEncoder.encode("prof123"),"MANAGER","");

        List<User> users = Arrays.asList(user,admin);

        // Save to db
        this.userRepository.saveAll(users);
    }
}
