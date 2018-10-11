package uti.ro.java.tutorials.jdbcex;

import javax.sql.DataSource;
import java.util.List;

public interface EmployeeDAO {

    //void setDataSource(DataSource ds);

    long insert(Employee e);

    Employee getEmployee(long id);

    List<Employee> listEmployees();

    void delete(long id);

    void update(long id, Employee e);
}
