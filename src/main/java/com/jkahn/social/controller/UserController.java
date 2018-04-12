package main.java.com.jkahn.social.controller;

import main.java.com.jkahn.social.objects.HomepageData;
import main.java.com.jkahn.social.objects.SentStatus;
import main.java.com.jkahn.social.objects.Status;
import main.java.com.jkahn.social.objects.User;
import main.java.com.jkahn.social.service.StatusService;
import main.java.com.jkahn.social.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Controller
@Scope("session")
@RequestMapping("user")
public class UserController {
    private final static Logger log = Logger.getLogger(UserController.class.getName());

    @Autowired
    UserService userService;
    @Autowired
    StatusService statusService;

    @GetMapping("/")
    public String reset(){
        return "index";
    }

    @PostMapping("/login")
    public void login(HttpServletRequest req, HttpServletResponse res) throws java.io.IOException{
        String email = req.getParameter("email");
        log.info("email");
        User theUser = userService.getUserByEmail(email);

        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session= attr.getRequest().getSession(true);
        session.setAttribute("user", theUser);

        res.sendRedirect("/user/homepage");
    }

    @RequestMapping(value="/signup", method= RequestMethod.GET)
    public ModelAndView signup(){
        return new ModelAndView("register");
    }

    @PostMapping(value = "/registerUser")
    public void register(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws java.io.IOException{
        Calendar c = Calendar.getInstance();
        if(userService.getUserByEmail("email") == null) {
            User newUser = new User((String) req.getParameter("firstName"), (String) req.getParameter("lastName"), (String) req.getParameter("email"), c.get(Calendar.MONTH) + 1, c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.YEAR));
            userService.addUser(newUser);
            session.setAttribute("user", newUser);
            res.sendRedirect("/user/homepage");
        }
        else{
            res.
        }
    }

    @RequestMapping(value="/homepage", method=RequestMethod.GET)
    public ModelAndView homepage(Model theModel){
        ModelAndView returnObj = new ModelAndView("home-screen");
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session= attr.getRequest().getSession(true);
        User currentUser = (User) session.getAttribute("user");
        List<Status> statuses = statusService.getStatuses(currentUser);

        HomepageData data = new HomepageData(statuses, currentUser);
        theModel.addAttribute("data", data);
        returnObj.addObject(theModel);
        return returnObj;
    }
    @PostMapping("/writeStatus")
    public void writeStatus(HttpServletRequest req){
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session= attr.getRequest().getSession(true);
        User currentUser = (User) session.getAttribute("user");

        Calendar c = Calendar.getInstance();
        Date date = new Date();
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE");

        Status status = new Status((String) req.getParameter("text"), currentUser, c.get(Calendar.MONTH)+1, c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.YEAR), simpleDateformat.format(date));

        statusService.addStatus(status);

    }
}
