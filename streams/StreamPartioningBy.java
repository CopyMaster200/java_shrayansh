package streams;

import model.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class StreamPartioningBy {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeUtil.createTestEmployees();

        Map<Boolean, List<Employee>> sal60000 = employees.stream()
                .collect(Collectors.partitioningBy(employee -> employee.getSalary() > 60000));
        System.out.println(sal60000.entrySet());
        System.out.println(sal60000.get(true));

        Map<String, List<Employee>> empGroupDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDept));
        empGroupDept.entrySet().forEach(System.out::println);

        Optional<Employee> salary3rdHigh = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .distinct()
                .skip(2)
                .limit(1)
                .findFirst();

        System.out.println(salary3rdHigh.orElseGet(null));

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        list.stream().mapToInt(Integer::intValue).sum();
        list.stream().mapToInt(Integer::intValue).summaryStatistics();


    }
}
