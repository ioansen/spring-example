package uti.ro.java.tutorials.jdbcex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

import javax.sql.DataSource;
import java.util.List;

public class EmployeeJDBCTemplate implements EmployeeDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PlatformTransactionManager transactionManager;


    @Override
    @Autowired
    public void setDataSource(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public void create(Employee e) {
        //minimal transaction example
        TransactionDefinition def = new DefaultTransactionAttribute();
        TransactionStatus status  = transactionManager.getTransaction(def);

        try {
            String SQL = "INSERT into employees (name,lastname,salary,department,job) " +
                    "values (?,?,?,?,?)";
            jdbcTemplate.update(SQL, e.getName(),
                    e.getLastname(),e.getSalary(), e.getDep(), e.getJob());

            //more database operations here
            transactionManager.commit(status);

        }catch (DataAccessException ex){
            //rollback the transaction in case of error
            transactionManager.rollback(status);
            throw ex;
        }

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
