package streams;


import model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ThirdHighestSalary {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeUtil.createTestEmployees();

        Map<String, Optional<Employee>> secondHighestSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDept,
                        Collectors.mapping(
                                emp -> emp, // Ensure proper type handling
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        list -> list.stream()
                                                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed()) // Sort by salary descending
                                                .distinct() // Remove duplicates
                                                .skip(1) // Skip the highest salary
                                                .findFirst() // Pick the second highest
                                )
                        )
                ));

        // Print the result
        secondHighestSalaryByDept.forEach((dept, emp) ->
                System.out.println(dept + " -> " + emp.map(Employee::toString).orElse("No second highest salary"))
        );

    }
}
