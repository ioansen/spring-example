package uti.ro.java.tutorials.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uti.ro.java.tutorials.employees.Employee;

@Controller
public class EmployeeController {

    @GetMapping("/employee")
    public String employee(ModelMap model) {
        model.addAttribute("employee", new Employee());
        return "/pages/employee.jsp";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute("employee") Employee e, BindingResult result,
                             ModelMap model) {

        if(result.hasErrors()){
            System.out.println(result.getAllErrors());
        }

        model.addAttribute("name", e.getName());
        model.addAttribute("lastname", e.getLastname());
        model.addAttribute("salary", e.getSalary());
        model.addAttribute("dep", e.getDep());
        model.addAttribute("job", e.getJob());

        return "/pages/result.jsp";
    }
}
