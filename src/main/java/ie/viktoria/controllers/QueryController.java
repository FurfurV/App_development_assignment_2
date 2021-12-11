package ie.viktoria.controllers;

import ie.viktoria.entities.Note;
import ie.viktoria.entities.Student;
import ie.viktoria.service.INoteService;
import ie.viktoria.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: Viktoria Cseke
 * @studentNumber: R00180598
 */

@Controller
public class QueryController {
    @Autowired
    IStudentService studentService;

    @Autowired
    INoteService noteService;

    @GetMapping("/student/{studentId}")
    public String showStudentByStudentId(@PathVariable("studentId") String studentId,
                                         Model model){
        Student student = studentService.getStudentById(studentId);
        if(student == null){
            model.addAttribute("studentId",studentId);
            return "notfounderror";
        }

        model.addAttribute("student",student);
        model.addAttribute("notes", noteService.getAllNotesFromStudent(studentId));
        return "student";
    }

    @GetMapping("/students")
    public String showStudents(Model model){
        model.addAttribute("students",studentService.getAllStudents());
        return "students";
    }
}
