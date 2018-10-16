package uti.ro.java.tutorials.employees;

public class Employee {

    private long id;
    private String name;
    private String lastname;
    private int salary;
    private String dep;
    private String job;

    public Employee() {
    }


    public Employee(String name, String lastname, int salary, String dep, String job) {
        this.name = name;
        this.lastname = lastname;
        this.salary = salary;
        this.dep = dep;
        this.job = job;
    }

   /* public Employee(long id, String name, String lastname, int salary, String dep, String job) {
        this(name, lastname, salary, dep, job);
    }*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "" + id + " " + name + " " + lastname + " " + salary + " " +
                dep + " " + job;
    }
}
