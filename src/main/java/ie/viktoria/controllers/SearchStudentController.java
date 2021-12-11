package ie.viktoria.controllers;

import ie.viktoria.entities.Student;
import ie.viktoria.forms.NewNoteForm;
import ie.viktoria.forms.NewStudentForm;
import ie.viktoria.forms.SearchStudentForm;
import ie.viktoria.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: Viktoria Cseke
 * @studentNumber: R00180598
 */
@Controller
public class SearchStudentController {

    @Autowired
    StudentService studentService;

//    @GetMapping("/student/{studentId}")
//    public String showStudentByStudentId(@PathVariable("studentId") String studentId,
//                                         Model model){
//        Student student = studentService.getStudentById(studentId);
//        if(student == null){
//            model.addAttribute("studentId",studentId);
//            return "notfounderror";
//        }
//
//        model.addAttribute("student",student);
//        return "student";
//    }
}
