package streams;


import model.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class PluralSightStreams1 {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeUtil.createTestEmployees();
        List<String> result = employees.stream()
                .filter(employee -> employee.getSalary() >= 50000)
                .map(Employee::getName)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Basic employee filter, map, reduce: " + result);
    }
}
