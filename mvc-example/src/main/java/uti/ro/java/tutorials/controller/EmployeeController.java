package uti.ro.java.tutorials.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import uti.ro.java.tutorials.employees.Employee;
import uti.ro.java.tutorials.employees.repo.EmployeeDAOImpl;
import uti.ro.java.tutorials.employees.EmployeeValidator;
import uti.ro.java.tutorials.employees.service.EmployeeService;

@Controller
@ControllerAdvice
public class EmployeeController {

    private EmployeeValidator employeeValidator;
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Autowired
    public void setEmployeeValidator(EmployeeValidator employeeValidator){
        this.employeeValidator = employeeValidator;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(employeeValidator);
    }

    @GetMapping("/addemp")
    public String employee(ModelMap model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("action_name", "Add");
        model.addAttribute("action", "addEmployee");
        return "addemployee";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute("employee") @Validated Employee e,
                              BindingResult result, ModelMap model) {

        if(result.hasErrors()){
            model.addAttribute("action_name", "Add");
            model.addAttribute("action", "addEmployee");
            return "addemployee";
        }

        employeeService.create(e);
        return "redirect:/employees";
    }

    @GetMapping("/employees")
    public String getEmployees(ModelMap model){
        model.addAttribute("employeeList", employeeService.getEmployees());
        return "employees";
    }

    @GetMapping("updateemp")
    public String update(@RequestParam long id, ModelMap model){
        model.addAttribute("employee", employeeService.getEmployee(id));
        model.addAttribute("action_name", "Modify");
        model.addAttribute("action", "updateEmployee");
        return "addemployee";
    }

    @PostMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute("employee") @Validated Employee e,
                              BindingResult result, ModelMap model) {

        if(result.hasErrors()){
            model.addAttribute("employee", e);
            model.addAttribute("action_name", "Modify");
            model.addAttribute("action", "updateEmployee");
            return "addemployee";
        }

        employeeService.update(e.getId(), e);

        return "redirect:/employees";

    }

    @GetMapping("deleteemp")
    public String deleteEmployee(@RequestParam long id, ModelMap model){
        employeeService.delete(id);
        return "redirect:/employees";

    }

}
