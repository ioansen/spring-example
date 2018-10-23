package uti.ro.java.tutorials.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import uti.ro.java.tutorials.dto.MessageDTO;
import uti.ro.java.tutorials.employees.Employee;
import uti.ro.java.tutorials.employees.EmployeeValidator;
import uti.ro.java.tutorials.employees.service.EmployeeService;

@RestController
@ControllerAdvice
@RequestMapping(value = "/rest/employees")
public class EmployeeRestController {

    private EmployeeValidator employeeValidator;
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
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

    @GetMapping
    public ResponseEntity<Object> getEmployees() {
        return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getEmployee(@PathVariable("id") long id) {
        return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createEmployee(@RequestBody @Validated Employee employee) {
        employeeService.create(employee);
        return new ResponseEntity<>(new MessageDTO(false, "Employee created successfully"), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable("id") long id, @RequestBody @Validated Employee employee) {
        employeeService.update(id, employee);
        return new ResponseEntity<>(new MessageDTO(false, "Employee updated successfully"), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable("id") long id) {
        employeeService.delete(id);
        return new ResponseEntity<>(new MessageDTO(false, "Employee deleted successfully"), HttpStatus.OK);
    }
}
