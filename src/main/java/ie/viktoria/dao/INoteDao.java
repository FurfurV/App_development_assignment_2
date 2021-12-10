package ie.viktoria.dao;

import ie.viktoria.entities.Note;
import ie.viktoria.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: Viktoria Cseke
 * @studentNumber: R00180598
 */
public interface INoteDao extends JpaRepository<Note,Integer> {
    boolean existsByStudentNote(Student student);

    List<Note> findAllByStudentNote_StudentId(String studentId);

    Note findByNoteId(int id);

//    List<Note> findAllByStudentNoteOrOrderByIdAsc(String studentId);

}
