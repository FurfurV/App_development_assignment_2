package ie.viktoria.controllers;

import ie.viktoria.entities.Note;
import ie.viktoria.entities.Student;
import ie.viktoria.forms.NewStudentForm;
import ie.viktoria.service.INoteService;
import ie.viktoria.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author: Viktoria Cseke
 * @studentNumber: R00180598
 */

@RestController
@RequestMapping("myapi")
public class MyRestController {

    @Autowired
    IStudentService studentService;

    @Autowired
    INoteService noteService;

    // return a student or 404
    @GetMapping("/student/{studentId}")
    ResponseEntity<Student> getStudent(@PathVariable(name="studentId") String studentId) {
        Student student = studentService.getStudentById(studentId);
        if (student == null)
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<Student>(student, HttpStatus.FOUND);
    }

    @GetMapping("/students")
    List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/studentNote/{studentId}")
    ResponseEntity<List<Note>> getNotesFromStudent(@PathVariable(name="studentId") String studentId) {
        Student student = studentService.getStudentById(studentId);
        if (student == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(noteService.getAllNotesFromStudent(studentId), HttpStatus.FOUND);
    }

    // http://localhost:8080/myapi/studentNote/R00123456
    // for testing
    // http://localhost:8080/myapi/student/R00123456
    // for testing

    // a delete request
    @DeleteMapping("/student/{studentId}")
    ResponseEntity<Student> deleteStudent2(@PathVariable(name="studentId") String studentId){
        boolean status = studentService.delete(studentId);
        if (status)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
