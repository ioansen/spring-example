package uti.ro.java.tutorials.service;

import uti.ro.java.tutorials.employees.Employee;

import java.util.List;

public interface EmployeeService {

    long create(Employee e);

    Employee getEmployee(long id);

    List<Employee> getEmployees();

    void delete(long id);

    void update(long id, Employee e);
}
