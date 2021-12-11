package ie.viktoria.service;

/**
 * @author: Viktoria Cseke
 * @studentNumber: R00180598
 */
import ie.viktoria.entities.OwnUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        Optional<OwnUser> optionalUser = userService.findByEmail(email);
        System.out.println(optionalUser.toString());
        if(optionalUser.isPresent())
        {
            OwnUser myUser = optionalUser.get();
            // Create an instance of Spring's User class using data from our database
            return User.builder()
                    .username(myUser.getEmail())
                    .password(passwordEncoder.encode(myUser.getPassword()))
                    .disabled( false )
                    .accountExpired( false )
                    .accountLocked( false )
                    .roles( myUser.getRole() )
                    .build();
        } else {
            throw new UsernameNotFoundException("User email " + email + " is not Found");
        }
    }
}
