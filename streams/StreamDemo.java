package streams;


import model.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamDemo {

    public static void main(String[] args) {
        List<Employee> empList = EmployeeUtil.createTestEmployees();
        System.out.println("Employee list: \n" + empList);
        sortEmpOnSalaryDesc(empList);
        groupEmpByDept(empList);
    }

    private static void sortEmpOnSalaryDesc(List<Employee> employees) {
        List<Employee> sortedEmp = employees.stream().sorted((o1, o2) -> (int) (o2.getSalary() - o1.getSalary())).collect(Collectors.toList());
        System.out.println("Sorted employees based on salary:\n" + sortedEmp);

        // fetch top 3 salaried employees
        System.out.println("Top 3 salaried employees:\n" + sortedEmp.stream().limit(3).collect(Collectors.toList()));

        System.out.println("Salaried employees after top 3:\n" + sortedEmp.stream().skip(3).collect(Collectors.toList()));
    }

    private static void groupEmpByDept(List<Employee> employees) {
        Map<String, Long> map = employees.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()));
        System.out.println(map);
    }
}
