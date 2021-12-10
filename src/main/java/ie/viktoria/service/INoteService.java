package ie.viktoria.service;

import ie.viktoria.entities.Note;
import ie.viktoria.entities.Student;

import java.time.LocalDate;
import java.util.List;

/**
 * @author: Viktoria Cseke
 * @studentNumber: R00180598
 */
public interface INoteService {
    List<Note> getAllNotes();
    List<Note> getAllNotesByOrder();
    List<Note> getAllNotesFromStudent(String studentId);
    Note save(int id,LocalDate date, String text, Student student);
    Note getNoteById(int id);
}
