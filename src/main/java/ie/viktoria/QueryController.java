package ie.viktoria;

import ie.viktoria.entities.Student;
import ie.viktoria.service.IStudentService;
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
public class QueryController {
    @Autowired
    IStudentService studentService;

    @GetMapping("/student/{studentId}")
    public String showStudentByStudentId(@PathVariable("studentId") int studentId,
                                         Model model){
        Student student = studentService.getStudentById(studentId);
        if(student == null){
            model.addAttribute("studentId",studentId);
            return "notfounderror";
        }

        model.addAttribute("student",student);
        return "student";
    }

    @GetMapping("/students")
    public String showStudents(Model model){
        model.addAttribute("students",studentService.getAllStudents());
        return "students";
    }
}
