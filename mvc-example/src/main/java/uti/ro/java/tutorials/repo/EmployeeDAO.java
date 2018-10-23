package uti.ro.java.tutorials.repo;

import uti.ro.java.tutorials.employees.Employee;

import java.util.List;

public interface EmployeeDAO {

    //void setDataSource(DataSource ds);

    long insert(Employee e);

    Employee findEmployee(long id);

    List<Employee> listEmployees();

    void delete(long id);

    void update(long id, Employee e);
}
