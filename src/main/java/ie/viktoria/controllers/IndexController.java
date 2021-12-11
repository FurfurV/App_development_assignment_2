package ie.viktoria.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: Viktoria Cseke
 * @studentNumber: R00180598
 */

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(
                        Model model){
        return "index";
    }

    @GetMapping("/403")
    public String accessDenied(
            Model model){
        return "403";
    }

    @GetMapping("/logout")
    public String logOut(
            Model model){
        return "logout";
    }

    @GetMapping("/login")
    public String logIn(
            Model model){
        return "login";
    }
}
