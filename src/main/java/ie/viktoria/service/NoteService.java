package ie.viktoria.service;

import ie.viktoria.dao.INoteDao;
import ie.viktoria.entities.Note;
import ie.viktoria.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Viktoria Cseke
 * @studentNumber: R00180598
 */
@Service
public class NoteService implements INoteService{

    @Autowired
    INoteDao noteDao;

    @Override
    public Note save( LocalDate date, String text,Student student){
//        if (noteDao.existsByStudentNote(student)){
//            return null;
//        }
        Note newNote = new Note (date,text,student);
        return noteDao.save(newNote);
    }

    @Override
    public List<Note> getAllNotes(){
        return noteDao.findAll();
    }

    @Override
    public List<Note> getAllNotesByOrder(){
        return noteDao.findAll();
    }

    @Override
    public List<Note> getAllNotesFromStudent(String studentId){
        return noteDao.findAllByStudentNote_StudentId(studentId);
    }

    @Override
    public Note getNoteById(int id){
        return noteDao.findByNoteId(id);
    }
}
