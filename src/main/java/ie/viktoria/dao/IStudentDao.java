package ie.viktoria.dao;

import ie.viktoria.entities.Note;
import ie.viktoria.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: Viktoria Cseke
 * @studentNumber: R00180598
 */
public interface IStudentDao extends JpaRepository<Student,String> {
//    List<Note> findAllByStudentNote_StudentId(int studentId);
    boolean existsByEmail(String email);

    Student findStudentByStudentId(String studentId);
}
