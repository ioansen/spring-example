package uti.ro.java.tutorials.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import uti.ro.java.tutorials.employees.Employee;
import uti.ro.java.tutorials.employees.EmployeeDAOImpl;
import uti.ro.java.tutorials.employees.EmployeeValidator;

@Controller
@ControllerAdvice
public class EmployeeController {

    private EmployeeValidator employeeValidator;
    private EmployeeDAOImpl employeeDAO;

    @Autowired
    public void setEmployeeValidator(EmployeeValidator employeeValidator){
        this.employeeValidator = employeeValidator;
    }

    @Autowired
    public void setEmployeeDAO(EmployeeDAOImpl employeeDAO) {
        this.employeeDAO = employeeDAO;
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

        employeeDAO.insert(e);
        return "redirect:/employees";
    }

    @GetMapping("/employees")
    public String getEmployees(ModelMap model){
        model.addAttribute("employeeList", employeeDAO.listEmployees());
        return "employees";
    }

    @GetMapping("updateemp")
    public String update(@RequestParam long id, ModelMap model){
        model.addAttribute("employee", employeeDAO.getEmployee(id));
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

        employeeDAO.update(e.getId(), e);

        return "redirect:/employees";

    }

    @GetMapping("deleteemp")
    public String deleteEmployee(@RequestParam long id, ModelMap model){
        employeeDAO.delete(id);
        return "redirect:/employees";

    }

}
