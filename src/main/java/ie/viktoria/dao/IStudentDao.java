package ie.viktoria.dao;

import ie.viktoria.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: Viktoria Cseke
 * @studentNumber: R00180598
 */
public interface IStudentDao extends JpaRepository<Student,String> {
    boolean existsByEmail(String email);

    Student findStudentByStudentId(String studentId);

    int deleteByStudentId(String studentId);
}
