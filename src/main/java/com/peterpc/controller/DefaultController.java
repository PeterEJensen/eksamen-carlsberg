package com.peterpc.controller;

//default controller class. It holds most remappings for our application
//Created by Peter & Fida

import com.peterpc.model.CustomerModel;
import com.peterpc.model.Post;
import com.peterpc.model.User;
import com.peterpc.services.CustomerModelService;
import com.peterpc.services.EmailService;
import com.peterpc.services.HibernateSearchService;
import com.peterpc.services.UserService;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DefaultController {

    @Autowired
    private HibernateSearchService searchservice;

    @Autowired
    private CustomerModelService cardservice;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;
    private EmailService emailService;

    public DefaultController(EmailService emailService){
        this.emailService = emailService;
    }

    @GetMapping("/calendar")
    String calendar(Model model) {
        return "calendar";
    }


    @RequestMapping(value = "/post", method = RequestMethod.GET)
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
        //model.addAttribute("users", userService.findByEmail(String email));
        //List<User> users = userService.getUserList();
        //model.addAttribute("users", users);

        log.info("index action ended...");
        return "admin";
    }


    @RequestMapping(value = "/", method = RequestMethod.GET) //get method to request data
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    //post method to send data (in this isntance, post a note to index)
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

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }



    @GetMapping("/search")
    public String search(@RequestParam(value = "search", required = false) String q, Model model) {
        List<CustomerModel> searchResults = null;
        try {
            searchResults = searchservice.fuzzySearch(q);
        } catch (Exception ex) {
        }
        SimpleMailMessage technicalEmail = new SimpleMailMessage();

        technicalEmail.setTo("noreplyspringboot@gmail.com");
        technicalEmail.setSubject("Vagtkald");
        technicalEmail.setText("Hej \n\nFølgende detaljer om kunden fremsendes:\n"
                + searchResults);
        technicalEmail.setFrom("noreply@domain.com");

        emailService.sendEmail(technicalEmail);

        model.addAttribute("confirmationMessage", "Vi har sendt vagtkaldet til  ");
        model.addAttribute("search", searchResults);
        return "search";
        /* kode til fremsendelse af kunden til tekniker. tekniker DB skal oprettes med link til deres mail*/
    }


}
