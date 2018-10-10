package uti.ro.java.tutorials.jdbcex;

import javax.sql.DataSource;
import java.util.List;

public interface EmployeeDAO {

    void setDataSource(DataSource ds);

    void create(Employee e);

    Employee getEmployee(int id);

    List<Employee> listEmployees();

    void delete(int id);

    void update(int id, Employee e);
}
