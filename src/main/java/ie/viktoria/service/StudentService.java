package ie.viktoria.service;

import ie.viktoria.dao.IStudentDao;
import ie.viktoria.entities.Note;
import ie.viktoria.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

/**
 * @author: Viktoria Cseke
 * @studentNumber: R00180598
 */
@Service
public class StudentService implements IStudentService{

    @Autowired
    IStudentDao studentDao;

    @Override
    public Student save(String id,String email, String firstName, String lastName){
        if (studentDao.existsById(id)){
            return null;
        }
        Student student = new Student(id, email, firstName, lastName);
        return studentDao.save(student);
    }

    @Override
    public Student shortSave(Student student){
        if (studentDao.existsById(student.getStudentId())){
            return null;
        }
        return studentDao.save(student);
    }

    @Override
    public List<Student> getAllStudents(){
        return studentDao.findAll();
    }

    @Override
    public Student getStudentById(String studentId){
        return studentDao.findStudentByStudentId(studentId);
    }

    @Override
    @Transactional
    public boolean delete(String studentId){
        if(studentDao.deleteByStudentId(studentId) == 1){
            return true;
        }
        System.out.println("no");
        return false;
    }

}
