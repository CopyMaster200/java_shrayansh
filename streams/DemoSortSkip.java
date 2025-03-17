package streams;


import model.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DemoSortSkip {


    public static void main(String[] args) {
        List<Employee> employeeList = EmployeeUtil.createTestEmployees();
        System.out.println("Employee list: " + employeeList);
        groupEmpByAge(employeeList);
        findSecondAndThirdYoungestAge(employeeList);
        getEmpNameAsStringWithCommaSeparated(employeeList);
        findDuplicateEmployeeBasedOnName(employeeList);
        groupByNameToFindDuplicates(employeeList);
    }

    private static void getEmpNameAsStringWithCommaSeparated(List<Employee> employeeList) {
        String result = employeeList.stream().map(emp -> emp.getName().toUpperCase()).sorted().collect(Collectors.joining(", "));
        System.out.println("getEmpNameAsStringWithCommaSeparated: " + result);
    }

    private static void findSecondAndThirdYoungestAge(List<Employee> employeeList) {
        List<Integer> nums = employeeList.stream().map(Employee::getAge).sorted().collect(Collectors.toList());
        System.out.println("Sorted ages: " + nums);
        System.out.println("Find the second and third youngest age: " + nums.stream().skip(1).limit(2).collect(Collectors.toList()));
    }

    private static void findDuplicateEmployeeBasedOnName(List<Employee> employeeList) {
        //In this approach able to get the duplicates and unique elements.
        Set<String> uniqEmpSet = new HashSet<>();
        List<String> dupEmp = employeeList.stream()
                .map(Employee::getName)
                .filter(name -> !uniqEmpSet.add(name))
                .collect(Collectors.toList());
        System.out.println("Duplicate employees: " + dupEmp);
    }

    private static void groupEmpByAge(List<Employee> employeeList) {
        Map<Integer, List<Employee>> result = employeeList.stream().collect(Collectors.groupingBy(Employee::getAge));
        System.out.println("GroupBy age: " + result);
    }

    private static void groupByNameToFindDuplicates(List<Employee> employeeList) {
        List<String> empNames = employeeList.stream().map(Employee::getName).collect(Collectors.toList());
        System.out.println("Emp names: " + empNames);

        Map<String, Long> result = empNames.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<String> findDupInMap = result.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        Set<String> dupUsingFreq = empNames.stream()
                .filter(name -> Collections.frequency(empNames, name) > 1)
                .collect(Collectors.toSet());

        System.out.println("Map: " + result + "\nDup: " + findDupInMap);
        System.out.println("duplicate using Collections.frequency: " + dupUsingFreq);
    }
}
