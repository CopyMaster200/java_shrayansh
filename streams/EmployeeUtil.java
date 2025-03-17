package streams;


import model.Employee;

import java.util.List;

public class EmployeeUtil {
    public static List<Employee> createTestEmployees() {
        return List.of(
                new Employee(1L, "John Doe", 30, 50000, "DEV"),
                new Employee(2L, "Jane Smith", 28, 55000, "QA"),
                new Employee(3L, "Bob Johnson", 35, 60000, "DEV"),
                new Employee(4L, "Alice Brown", 32, 48000, "QA"),
                new Employee(5L, "Tony Stark", 32, 80000, "DEV"),
                new Employee(6L, "Tony Stark", 32, 80000, "QA")
        );
    }
}
