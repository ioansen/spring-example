package uti.ro.java.tutorials.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import uti.ro.java.tutorials.employees.Employee;
import uti.ro.java.tutorials.employees.EmployeeValidator;

@Controller
@ControllerAdvice
public class EmployeeController {

    private EmployeeValidator employeeValidator;

    @Autowired
    public void setEmployeeValidator(EmployeeValidator employeeValidator){
        this.employeeValidator = employeeValidator;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(employeeValidator);
    }

    @GetMapping("/employee")
    public String employee(ModelMap model) {
        model.addAttribute("employee", new Employee());
        return "employee";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute("employee") @Validated Employee e,
                              BindingResult result,
                              ModelMap model) {

        if(result.hasErrors()){
            return "employee";
        }

        model.addAttribute("name", e.getName());
        model.addAttribute("lastname", e.getLastname());
        model.addAttribute("salary", e.getSalary());
        model.addAttribute("dep", e.getDep());
        model.addAttribute("job", e.getJob());

        return "result";
    }
}
