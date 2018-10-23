package uti.ro.java.tutorials.employee.mockrepo;

import uti.ro.java.tutorials.employees.Employee;
import uti.ro.java.tutorials.repo.EmployeeDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeDAOMock implements EmployeeDAO {
    private static Map<Long, Employee> employeeRepo = new HashMap<>();
    private static long nextEmployeeId = 1;

    @Override
    public long insert(Employee e) {
        employeeRepo.put(nextEmployeeId++, e);
        return  nextEmployeeId-1;
    }

    @Override
    public List<Employee> listEmployees() {
        return new ArrayList<>(employeeRepo.values());
    }

    @Override
    public Employee findEmployee(long id) {
        return employeeRepo.get(id);
    }

    @Override
    public void update(long id, Employee e) {
        employeeRepo.put(id,e);
    }

    @Override
    public void delete(long id) {
        employeeRepo.remove(id);
    }

}
