package ie.viktoria.controllers;

import ie.viktoria.entities.Student;
import ie.viktoria.forms.SearchStudentForm;
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
public class SearchStudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public String searchAStudent(Model model, Student student){
        model.addAttribute("searchStudentForm", new SearchStudentForm());
        model.addAttribute("studentId", studentService.getStudentById(student.getStudentId()));
        return "index";
    }

    @PostMapping("/")
    public String searchAStudentPost(@Valid SearchStudentForm searchStudentForm,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            return "index";
        }

        String id = searchStudentForm.getSearchStudentId();
        Student student = studentService.getStudentById(searchStudentForm.getSearchStudentId());

        if( student != null){
            return "redirect:student/" + student.getStudentId();
        }
        redirectAttributes.addFlashAttribute("notfoundid",true);
        return "redirect:/";
    }
}
