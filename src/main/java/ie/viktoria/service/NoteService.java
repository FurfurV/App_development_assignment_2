package ie.viktoria.service;

import ie.viktoria.dao.INoteDao;
import ie.viktoria.entities.Note;
import ie.viktoria.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

//    @Override
//    public Note save(Student studentId,String date, String text){
//        if (noteDao.existsByIdAndStudentNote(studentId)){
//            return null;
//        }
//        Note newNote = new Note(date,text,studentId);
//        return noteDao.save(newNote);
//    }

//    @Override
    public List<Note> getAllNotes(){
        return noteDao.findAll();
    }

//    @Override
    public List<Note> getAllNotesFromStudent(int studentId){
        return noteDao.findAllByStudentNote_StudentId(studentId);
    }
}
