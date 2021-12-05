package ie.viktoria.service;

import ie.viktoria.entities.Note;
import ie.viktoria.entities.Student;

import java.util.List;

/**
 * @author: Viktoria Cseke
 * @studentNumber: R00180598
 */
public interface INoteService {
    List<Note> getAllNotes();
    List<Note> getAllNotesFromStudent(int studentId);

//    Note save(Student studentId,String date, String text);
}
