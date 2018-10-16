package uti.ro.java.tutorials.employees.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import uti.ro.java.tutorials.employees.Employee;
import uti.ro.java.tutorials.employees.repo.EmployeeDAO;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public long create(Employee e) {
        return employeeDAO.insert(e);
    }

    @Override
    public Employee getEmployee(long id) {
        return employeeDAO.findEmployee(id);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeDAO.listEmployees();
    }

    @Override
    public void update(long id, Employee e) {
        employeeDAO.update(id, e);
    }

    @Override
    public void delete(long id) {
        employeeDAO.delete(id);
    }
}
