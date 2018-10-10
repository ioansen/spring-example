package uti.ro.java.tutorials.jdbcex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class EmployeeJDBCTemplate implements EmployeeDAO {

    private JdbcTemplate jdbcTemplate;

    @Override
    @Autowired
    public void setDataSource(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public void create(Employee e) {
        String SQL = "INSERT into employees (name,lastname,salary,department,job) " +
                "values (?,?,?,?,?)";
        jdbcTemplate.update(SQL, e.getName(), e.getLastname(),e.getSalary(), e.getDep(), e.getJob());
        System.out.println("[JDBC EXAMPLE]: Inserting Record");

    }

    @Override
    public Employee getEmployee(int id) {
        String SQL = "SELECT * from employees where id = ?";
        Employee e = jdbcTemplate.queryForObject(SQL,
                new Object[]{id}, new EmployeeMapper());
        System.out.println("[JDBC EXAMPLE]: Getting Record with ID = " + id );
        return e;
    }

    @Override
    public List<Employee> listEmployees() {
        String SQL = "select * from employees";
        List<Employee> employees = jdbcTemplate.query(SQL, new EmployeeMapper());
        System.out.println("[JDBC EXAMPLE]: Listing Employees" );
        return employees;
    }

    @Override
    public void delete(int id) {
        String SQL = "delete from employees where id = ?";
        jdbcTemplate.update(SQL, id);
        System.out.println("[JDBC EXAMPLE]: Deleted Record with ID = " + id );

    }

    @Override
    public void update(int id, Employee e) {
        String SQL = "UPDATE employees SET name=?, lastname=?, salary=?, department=?, job = ? WHERE id = ?";
        jdbcTemplate.update(SQL, e.getName(), e.getLastname(),e.getSalary(), e.getDep(), e.getJob(), id);
        System.out.println("[JDBC EXAMPLE]: Updated Record with ID = " + id );
    }
}
