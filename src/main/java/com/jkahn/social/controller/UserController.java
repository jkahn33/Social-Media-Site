package main.java.com.jkahn.social.controller;

import main.java.com.jkahn.social.objects.*;
import main.java.com.jkahn.social.service.StatusService;
import main.java.com.jkahn.social.service.UserService;
import org.apache.http.protocol.HTTP;
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
        User theUser = userService.getUserByEmail(email).get(0);

        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session= attr.getRequest().getSession(true);
        session.setAttribute("user", theUser);

        res.sendRedirect("/user/homepage");
    }

    @RequestMapping(value="/signup", method= RequestMethod.GET)
    public ModelAndView signup(Model theModel){
        ModelAndView returnObj = new ModelAndView("register");
        RegisterCheck rc = new RegisterCheck(true);
        theModel.addAttribute("check", rc);
        returnObj.addObject(theModel);
        return returnObj;
    }

    @PostMapping(value = "/registerUser")
    public ModelAndView register(HttpServletRequest req, HttpServletResponse res, HttpSession session, Model theModel) throws java.io.IOException{
        Calendar c = Calendar.getInstance();
        List<User> userList = userService.getUserByEmail(req.getParameter("email"));
        if(userList.size() == 0) {
            int month = c.get(Calendar.MONTH) + 1;
            int day = c.get(Calendar.DAY_OF_MONTH);
            int year = c.get(Calendar.YEAR);

            User newUser = new User((String) req.getParameter("firstName"), (String) req.getParameter("lastName"), (String) req.getParameter("email"), month, day, year, (month+day+year));
            userService.addUser(newUser);

            session.setAttribute("user", newUser);
            res.sendRedirect("/user/homepage");
            return null;
        }
        else{
            ModelAndView returnObj = new ModelAndView("register");
            RegisterCheck rc = new RegisterCheck(false);
            theModel.addAttribute("check", rc);
            returnObj.addObject(theModel);
            return returnObj;
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
    public void writeStatus(HttpServletRequest req, HttpServletResponse res) throws java.io.IOException{
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session= attr.getRequest().getSession(true);
        User currentUser = (User) session.getAttribute("user");

        Calendar c = Calendar.getInstance();
        Date date = new Date();
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE");

        Status status = new Status((String) req.getParameter("text"), currentUser, c.get(Calendar.MONTH)+1, c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.YEAR), simpleDateformat.format(date));

        statusService.addStatus(status);

        res.sendRedirect("/user/homepage");

    }
    @GetMapping("/testStatuses")
    public void testStatuses(){
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session= attr.getRequest().getSession(true);
        User currentUser = (User) session.getAttribute("user");
        List<Status> statuses = statusService.getStatuses(currentUser);
        for(Status s : statuses){
            log.info(s.getText());
        }
    }
    @GetMapping("/testFriend")
    public void addFriend(){
        int friendId = 4;
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session= attr.getRequest().getSession(true);
        User currentUser = (User) session.getAttribute("user");

        User friend = userService.getUserById(friendId);
        userService.addFriend(currentUser, friend);
    }
    @GetMapping("/checkFriends")
    public void checkUsers(){
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session= attr.getRequest().getSession(true);
        User currentUser = (User) session.getAttribute("user");
        List<User> users = currentUser.getFriends();

        for(User u : users){
            log.info("FRIEND: " + u.getFirst() + " " + u.getLast());
        }
    }
}
