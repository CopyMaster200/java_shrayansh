package streams;

import model.Employee;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class ForToStream {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeUtil.createTestEmployees();

        long start = System.nanoTime();
        int sum = 0, count = 0;
        for (int i = 0; i < employees.size(); i++) {
            sum += employees.get(i).getSalary();
            count++;
        }
        System.out.println("sum: " + sum + " emp count: " + count);
        System.out.println(count > 0 ? sum / count : 0);
        long end = System.nanoTime();
        System.out.println(end - start + " ns");

        long startTime = System.nanoTime();
        Double avg = employees.stream()
                .map(Employee::getSalary)
                .collect(Collectors.averagingDouble(x -> x));

        System.out.println(Math.floor(avg));
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime + " ns");

        OptionalDouble avgInt = employees.stream().mapToLong(emp -> (long) emp.getSalary()).average();
        avgInt.ifPresent(x -> System.out.println(Math.floor(avgInt.getAsDouble())));

    }
}
