package ie.viktoria.dao;

import ie.viktoria.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: Viktoria Cseke
 * @studentNumber: R00180598
 */
public interface IUserDao extends JpaRepository<User,String> {
    User findUserByEmail(String email);
    User findByEmail(String email);     //same as above


}
