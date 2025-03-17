package model;

public class Employee implements Comparable<Employee> {
    private long id;
    private String name;
    private int age;
    private float salary;
    private String dept;

    public Employee(long id, String name, int age, float salary, String dept) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.dept = dept;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public int compareTo(Employee emp) {
        if (id == emp.getId())
            return 0;
        else if (id > emp.getId())
            return 1;
        else
            return -1;
    }
}
