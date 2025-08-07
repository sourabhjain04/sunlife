package com.WebMVCProject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @RequestMapping("/greet")
    public String greet(@RequestParam(defaultValue="Guest") String name, Model model) {
        System.out.println("hello controller");
        model.addAttribute("message", "Hello " + name + ", welcome to Spring MVC!");
        return "home";  // Looks for /WEB-INF/views/home.jsp
    }
}
