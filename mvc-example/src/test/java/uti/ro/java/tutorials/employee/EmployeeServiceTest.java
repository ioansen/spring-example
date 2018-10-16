package uti.ro.java.tutorials.employee;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import uti.ro.java.tutorials.employees.Employee;
import uti.ro.java.tutorials.employees.repo.EmployeeDAO;
import uti.ro.java.tutorials.employee.mockrepo.EmployeeDAOMock;
import uti.ro.java.tutorials.employees.service.EmployeeService;
import uti.ro.java.tutorials.employees.service.EmployeeServiceImpl;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class EmployeeServiceTest {

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public EmployeeDAO employeeDAO() {
            return new EmployeeDAOMock();
        }

        @Bean
        public EmployeeService employeeService() {
            return new EmployeeServiceImpl(employeeDAO());
        }
    }

    private EmployeeService service;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.service = employeeService;
    }

    @Test
    public void testEmployeeService(){
        Employee e2 = new Employee("Nano", "Maman", 5500, null, "dex");
        Employee e1 = new Employee("Rajabov", "Gurijihidibidadi", 500, null, null);

        service.create(e1);
        long id = service.create(e2);
        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        assertEquals(service.getEmployees(), employees);

        assertEquals("Nano", service.getEmployee(id).getName());
        e2.setName("Radix");
        service.update(id, e2);
        assertEquals("Radix", service.getEmployee(id).getName());
        service.delete(id);


    }
}
