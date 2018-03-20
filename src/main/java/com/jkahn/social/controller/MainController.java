package main.java.com.jkahn.social.controller;

import main.java.com.jkahn.social.objects.SentUser;
import main.java.com.jkahn.social.objects.User;
import main.java.com.jkahn.social.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.Calendar;
import java.util.logging.Logger;

@Controller
public class MainController {
    private final static Logger log = Logger.getLogger(MainController.class.getName());

    @Autowired
    UserService userService;

    @GetMapping("/signup")
    public String signUpButton(){
        return "sign-up";
    }

    @PostMapping(value = "/registerUser")
    public void register(@RequestBody SentUser user, HttpServletResponse res, Model theModel) throws java.io.IOException{

        log.info(user.getFirst());
        Calendar c = Calendar.getInstance();
        User newUser = new User(user.getFirst(), user.getLast(), user.getEmail(), c.get(Calendar.MONTH)+1, c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.YEAR));
        userService.addUser(newUser);

        theModel.addAttribute("user", user);
        res.sendRedirect("/homepage");
    }

    @GetMapping("/homepage")
    public void homepage(){
    }
}
