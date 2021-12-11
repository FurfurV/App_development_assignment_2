package ie.viktoria.service;

import ie.viktoria.entities.OwnUser;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

/**
 * @author: Viktoria Cseke
 * @studentNumber: R00180598
 */
public interface IUserService {
    OwnUser save(OwnUser ownUser);
    Optional<OwnUser> findByEmail(String username);
}
