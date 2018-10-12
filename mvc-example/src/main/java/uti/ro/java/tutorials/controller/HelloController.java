package uti.ro.java.tutorials.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String printHello(ModelMap modelMap){
        modelMap.addAttribute("message", "This is a hello message");
        return "hello.jsp";
    }
}
