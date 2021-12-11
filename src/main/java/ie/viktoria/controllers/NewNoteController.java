package ie.viktoria.controllers;

import ie.viktoria.entities.Note;
import ie.viktoria.entities.Student;
import ie.viktoria.forms.NewNoteForm;
import ie.viktoria.service.NoteService;
import ie.viktoria.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * @author: Viktoria Cseke
 * @studentNumber: R00180598
 */
@Controller
public class NewNoteController {
    @Autowired
    NoteService noteService;

    @Autowired
    StudentService studentService;

    @GetMapping("newnote")
    public String addANote(Model model){
        model.addAttribute("newNoteForm", new NewNoteForm());
        model.addAttribute("students", studentService.getAllStudents());

        System.out.println(studentService.getAllStudents());
        return "newnote";
    }


    @PostMapping("newnote")
    public String addNewNote(Model model, @Valid NewNoteForm newNoteForm,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            model.addAttribute("students", studentService.getAllStudents());
            return "newnote";
        }

        Student student = studentService.getStudentById(newNoteForm.getStudentId());
        Note newNote = noteService.save( newNoteForm.getDate(), newNoteForm.getNewNoteText(), student);

        if ( newNote == null){
            redirectAttributes.addFlashAttribute("duplicateStudent", student.getStudentId());
            return "redirect:newnote";
        }

        redirectAttributes.addFlashAttribute("successful", student.getStudentId());
        return "redirect:newnote";
    }
}
