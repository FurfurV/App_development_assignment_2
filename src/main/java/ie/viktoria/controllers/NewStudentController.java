package ie.viktoria.controllers;

import ie.viktoria.entities.Student;
import ie.viktoria.forms.NewStudentForm;
import ie.viktoria.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * @author: Viktoria Cseke
 * @studentNumber: R00180598
 */
@Controller
public class NewStudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/newstudent")
    public String addAStudent(Model model){
        model.addAttribute("newStudentForm", new NewStudentForm());
        return "newstudent";
    }

    @PostMapping("/newstudent")
    public String addAStudentPost(@Valid NewStudentForm newStudentForm,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            return "newstudent";
        }
        Student student = studentService.save(newStudentForm.getNewStudentId(),
                newStudentForm.getNewStudentEmail(),
                newStudentForm.getNewStudentFirstName(),
                newStudentForm.getNewStudentLastName());
        if( student == null){
            redirectAttributes.addFlashAttribute("duplicateStudentId",true);
            return "redirect:newstudent";
        }

        return "redirect:student/" + student.getStudentId();
    }
}
