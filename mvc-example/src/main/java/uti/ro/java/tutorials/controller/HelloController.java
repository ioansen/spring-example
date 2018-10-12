package uti.ro.java.tutorials.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HelloController {

    @GetMapping("/hello")
    public String printHello(ModelMap modelMap){
        modelMap.addAttribute("message", "This is a hello message");
        return "/pages/hello.jsp";
    }

    @GetMapping
    @PostMapping
    public String index(){
        return "/pages/index.jsp";
    }
}
