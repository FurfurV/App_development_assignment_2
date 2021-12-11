package ie.viktoria.service;

import ie.viktoria.dao.IUserDao;
import ie.viktoria.entities.OwnUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author: Viktoria Cseke
 * @studentNumber: R00180598
 */
@Service
public class UserService implements IUserService{

    @Autowired
    IUserDao userDao;

    @Override
    public OwnUser save(OwnUser ownUser){
        return userDao.save(ownUser);
    }

    @Override
    public Optional<OwnUser> findByEmail(String email){
        return userDao.findUserByEmail(email);
    }
}
