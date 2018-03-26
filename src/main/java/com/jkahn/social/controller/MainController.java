package main.java.com.jkahn.social.controller;

import main.java.com.jkahn.social.objects.SentUser;
import main.java.com.jkahn.social.objects.User;
import main.java.com.jkahn.social.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.logging.Logger;

@Controller
@Scope("session")
public class MainController {
    private final static Logger log = Logger.getLogger(MainController.class.getName());

    @Autowired
    UserService userService;

    @Autowired

    @GetMapping("/")
    public String reset(){
        return "index";
    }

    @GetMapping("/signup")
    public String signUpButton(){
        return "sign-up";
    }

    @PostMapping(value = "/registerUser")
    public void register(@RequestBody SentUser user, HttpServletResponse res, HttpSession session) throws java.io.IOException{

        log.info(user.getFirst());
        Calendar c = Calendar.getInstance();
        User newUser = new User(user.getFirst(), user.getLast(), user.getEmail(), c.get(Calendar.MONTH)+1, c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.YEAR));
        userService.addUser(newUser);
        session.setAttribute("user", newUser);
        res.sendRedirect("/homepage");
    }

    @RequestMapping(value="/homepage", method=RequestMethod.GET)
    public String homepage(){
//        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
//        HttpSession session= attr.getRequest().getSession(true);
//        User currentUser = (User) session.getAttribute("user");
//        theModel.addAttribute("user", currentUser);
//        log.info("redirecting");
        return "home-screen";
    }
}
