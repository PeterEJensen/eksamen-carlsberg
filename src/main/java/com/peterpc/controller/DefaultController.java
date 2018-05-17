package com.peterpc.controller;

import com.peterpc.model.Post;
import com.peterpc.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DefaultController {


    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    @RequestMapping(path = "/calendar", method = RequestMethod.GET)
    String calendar(Model model) {
        return "calendar";
    }



    @RequestMapping(value="/post", method=RequestMethod.GET)
    public String post(Post post) {
        return "post";
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String addNewPost(@Valid Post post, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "post";
        }
        model.addAttribute("title", post.getTitle());
        model.addAttribute("content", post.getContent());
        return "index";
    }


    @GetMapping("/admin")
    public String admin(Model model) {
        log.info("index action called...");
       // model.addAttribute("students", userService.fetchAllUsers());

        log.info("index action ended...");
        return "admin";
    }



   @RequestMapping(value="/", method=RequestMethod.GET)
    public String index(Post post) {
        return "index";
    }
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String ShowPost(@Valid Post post, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "index";
        }
        model.addAttribute("title", post.getTitle());
        model.addAttribute("content", post.getContent());
        return "index";
    }



    @GetMapping("/user")
    public String user(Model model) {
        return "/user";
    }


    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }


}
