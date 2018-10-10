package uti.ro.java.tutorials.jdbcex;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {

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
