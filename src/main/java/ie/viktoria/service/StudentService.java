package ie.viktoria.service;

import ie.viktoria.dao.IStudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Viktoria Cseke
 * @studentNumber: R00180598
 */
@Service
public class StudentService implements IStudentService{

    @Autowired
    IStudentDao studentDao;

//    @Override
//    public List<Note> getAllProperties() {
//        if(propertyRepository.getAllProperties() == null){
//            log.error(ERROR_MESS);
//        }
//        return propertyRepository.getAllProperties();
//    }
}
