package main.java.com.jkahn.social.controller;

import main.java.com.jkahn.social.objects.User;
import main.java.com.jkahn.social.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.logging.Logger;

@Controller
@Scope("session")
@RequestMapping("login")
public class MainController {
    private final static Logger log = Logger.getLogger(MainController.class.getName());

    @Autowired
    UserService userService;

    @Autowired

    @GetMapping("/")
    public String reset(){
        return "index";
    }

    @RequestMapping(value="/signup", method= RequestMethod.GET)
    public ModelAndView signup(){
        return new ModelAndView("register");
    }

    @PostMapping(value = "/registerUser")
    public void register(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws java.io.IOException{

        Calendar c = Calendar.getInstance();
        User newUser = new User((String)req.getAttribute("iFirst"), (String)req.getAttribute("iLast"), (String)req.getAttribute("iEmail"), c.get(Calendar.MONTH)+1, c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.YEAR));
        userService.addUser(newUser);
        session.setAttribute("user", newUser);
        log.info(newUser.getFirst());
        res.sendRedirect("/login/homepage");
    }

    @RequestMapping(value="/homepage", method=RequestMethod.GET)
    public ModelAndView homepage(){
        log.info("Inside homepage");
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session= attr.getRequest().getSession(true);
        User currentUser = (User) session.getAttribute("user");
        theModel.addAttribute("user", currentUser);
        log.info("redirecting");
        return new ModelAndView("home-screen");
    }
}
