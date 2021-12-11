package ie.viktoria.dao;

import ie.viktoria.entities.OwnUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author: Viktoria Cseke
 * @studentNumber: R00180598
 */
public interface IUserDao extends JpaRepository<OwnUser, String> {
    Optional<OwnUser> findUserByEmail(String email);

    OwnUser findByEmail(String email);     //same as above

}
