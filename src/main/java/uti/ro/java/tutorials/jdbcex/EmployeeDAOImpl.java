package uti.ro.java.tutorials.jdbcex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Transactional
@Repository
@DependsOn({"transactionManager", "dataSource"})
public class EmployeeDAOImpl implements EmployeeDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDAOImpl(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public long insert(Employee e) {

        String SQL = "INSERT into employees (name,lastname,salary,department,job) " +
                "values (?,?,?,?,?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(SQL, new String[]{"id"});
            ps.setString(1, e.getName());
            ps.setString(2, e.getLastname());
            ps.setString(3, String.valueOf(e.getSalary()));
            ps.setString(4, e.getDep());
            ps.setString(5, e.getJob());
            return ps;
        }, keyHolder);
        System.out.println("[JDBC EXAMPLE]: Inserting Record");
        return (Long) keyHolder.getKey();
    }

    @Override
    @Transactional(readOnly = true)
    public Employee getEmployee(long id) {
        String SQL = "SELECT * from employees where id = ?";
        Employee e = jdbcTemplate.queryForObject(SQL,
                new Object[]{id}, new EmployeeMapper());
        System.out.println("[JDBC EXAMPLE]: Getting Record with ID = " + id );
        return e;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> listEmployees() {
        String SQL = "select * from employees";
        List<Employee> employees = jdbcTemplate.query(SQL, new EmployeeMapper());
        System.out.println("[JDBC EXAMPLE]: Listing Employees" );
        return employees;
    }

    @Override
    public void delete(long id) {
        String SQL = "delete from employees where id = ?";
        jdbcTemplate.update(SQL, id);
        System.out.println("[JDBC EXAMPLE]: Deleted Record with ID = " + id );

    }

    @Override
    public void update(long id, Employee e) {
        String SQL = "UPDATE employees SET name=?, lastname=?, salary=?, department=?, job = ? WHERE id = ?";
        jdbcTemplate.update(SQL, e.getName(), e.getLastname(),e.getSalary(), e.getDep(), e.getJob(), id);
        System.out.println("[JDBC EXAMPLE]: Updated Record with ID = " + id );
    }

    private static class EmployeeMapper implements RowMapper<Employee> {

        @Override
        public Employee mapRow(ResultSet rs, int rowColumn) throws SQLException{
            Employee employee = new Employee();
            employee.setId(rs.getInt("id"));
            employee.setName(rs.getString("name"));
            employee.setLastname(rs.getString("lastname"));
            employee.setSalary(rs.getInt("salary"));
            employee.setDep(rs.getNString("department"));
            employee.setJob(rs.getString("job"));

            return employee;
        }
    }

}
