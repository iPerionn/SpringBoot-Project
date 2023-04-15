package com.example.demo.controller;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Activity;
import com.example.demo.model.Comment;
import com.example.demo.model.User;
import com.example.demo.service.ActivityService;
import com.example.demo.service.CommentService;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpServletResponse;


@Controller // This means that this class is a Controller
public class MainController {
    @Autowired
    private UserService userService;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/")
    public String home(){
        return "menu";
    }

    @GetMapping("/activity")
    public String activities(Model model){
        model.addAttribute("activities", activityService.getActivities());
        return "activity";
    }

    @GetMapping("/activity/{id}")
    public String activity(@PathVariable("id") String id, Model model){
        //CHECK IF id IS AN INT
        Activity activity = activityService.findById(Integer.valueOf(id));
        model.addAttribute("activity", activity);
        model.addAttribute("comments", commentService.findByActivity(activity));

        model.addAttribute("comment", new Comment());
        model.addAttribute("users", userService.getUsers());
        return "activityDetails";
    }

    @PostMapping(path = "/addComment/{activity_id}")
    public void createUser(
        @ModelAttribute Comment comment, 
    Model model,@PathVariable("activity_id") String activity_id,HttpServletResponse response) throws IOException
    {
        comment.setActivity(activityService.findById(Integer.valueOf(activity_id)));
        commentService.saveComment(comment);
        response.sendRedirect("/activity/"+activity_id);
    }

    @GetMapping(path = "/connexion")
    public String connexion(){
        return "connexion";
    }
    @GetMapping(path = "/inscription")
    public String inscription(Model model){
        model.addAttribute("user", new User());
        return "inscription";
    }
    @GetMapping(path = "/menu")
    public String menu(){
        return "menu";
    }

    @PostMapping(path = "/createUser")
    public String createUser(@ModelAttribute User user, Model model){
        userService.saveUser(user);
        return "connexion";
    }

    @GetMapping("/user")
    public String users(Model model){
        model.addAttribute("users", userService.getUsers());
        return "user";
    }

    @GetMapping("/user/{id}")
    public String user(@PathVariable("id") String id, Model model){
        //CHECK IF id IS AN INT
        User user = userService.findById(Integer.valueOf(id));
        model.addAttribute("user", user);
        return "userDetails";
    }
    
}