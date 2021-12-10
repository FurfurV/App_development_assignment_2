package ie.viktoria;

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
//    @GetMapping("/")
//    public String index(@RequestParam("myname") String name,
//                        @RequestParam("myemail") String email,
//                        Model model){
//        model.addAttribute("myName",name);
//        model.addAttribute("myEmail",email);
//        return "index";
//    }
    @GetMapping("/")
    public String index(
                        Model model){
        return "index";
    }
    
//    @GetMapping("/{myname}/{myemail}")
//    public String indexPath(@PathVariable("myname") String name,
//                        @PathVariable("myemail") String email,
//                        Model model){
//        model.addAttribute("myName",name);
//        model.addAttribute("myEmail",email);
//        return "index";
//    }

    @PostMapping("/")
    public String indexPost(){
        return "index";
    }
}
