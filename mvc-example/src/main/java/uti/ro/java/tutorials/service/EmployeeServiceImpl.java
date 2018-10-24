package uti.ro.java.tutorials.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uti.ro.java.tutorials.employees.Employee;
import uti.ro.java.tutorials.employees.EmployeeNotFoundException;
import uti.ro.java.tutorials.repo.EmployeeDAO;
import uti.ro.java.tutorials.repo.EmployeeRepository;

import java.util.List;
import java.util.Optional;

//@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService{

   /* private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }*/

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public long create(Employee e) {
        return employeeRepository.save(e).getId();
    }

    @Override
    //@Transactional(readOnly = true)
    public Employee getEmployee(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        if (!employee.isPresent())
            throw new EmployeeNotFoundException("id-" + id);

        return employee.get();
    }

    @Override
    //@Transactional(readOnly = true)
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void update(long id, Employee e) {
        employeeRepository.save(e);
    }

    @Override
    public void delete(long id) {
        employeeRepository.deleteById(id);
    }
}
