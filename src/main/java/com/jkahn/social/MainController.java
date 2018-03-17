package main.java.com.jkahn.social;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
@RequestMapping("/home")
public class MainController {
    private final static Logger log = Logger.getLogger(MainController.class.getName());

    @GetMapping("/signup")
    public String postStatus(){
        return "sign-up";
    }
}
