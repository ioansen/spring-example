package uti.ro.java.tutorials.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uti.ro.java.tutorials.employees.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
