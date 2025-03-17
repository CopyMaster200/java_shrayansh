package interviews;

import model.Emp;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EpamStream {
    public static void main(String[] args) {
        List<Emp> employees = Arrays.asList(
                new Emp(101L, "Alice", 50000, "CSE"),
                new Emp(102L, "Bob", 60000, "CSE"),
                new Emp(103L, "Charlie", 70000, "ECE"),
                new Emp(104L, "David", 80000, "ECE"),
                new Emp(105L, "Kevin", 80000, "IT")
        );



//        predicates();
//        charCountNoDS();
//        charCountUsingStack();
//        secondHighSalInEachDept(employees);
//        highestSalaryInEachDept(employees);
//        greaterThanAvgSal(employees);
//        getEmployeeMap(employees);
    }

    private static void predicates() {
        BiPredicate<String, Integer> checkSame = (str, num) -> str.equals(num.toString());
        Predicate<Integer> isEven = num -> num % 2 == 0;

        System.out.println(checkSame.test("6", 6));
        System.out.println(isEven.test(9));
    }

    private static void charCountNoDS() {
        String str = "aabbbccddeeaa"; // a2b3c2d2e2a2
        int i = 0, count = 1;
        StringBuilder sb = new StringBuilder();
        while (i < str.length() - 1) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            } else {
                sb.append(str.charAt(i)).append(count);
                count = 1;
                i++;
            }
        }
        sb.append(str.charAt(i)).append(count);
        System.out.println(sb);
    }

    private static void charCountUsingStack() {
        String str = "aabbbccddeeaa"; // a2b3c2d2e2a2

        char[] arr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty() || stack.peek().equals(arr[i]))
                stack.push(arr[i]);
            else {
                sb.append(stack.peek()).append(stack.size());
                stack.clear();
                stack.push(arr[i]);
            }
        }
        // Add last character and count
        if (!stack.isEmpty()) {
            sb.append(stack.peek()).append(stack.size());
        }

        System.out.println(sb);
    }

    private static void secondHighSalInEachDept(List<Emp> employees) {
        Map<String, Optional<Emp>> secondHighestSal = employees.stream()
                .collect(Collectors.groupingBy(Emp::getDepartment,
                        Collectors.mapping(
                                emp -> emp,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        list -> list.stream()
                                                .distinct()
                                                .sorted(Comparator.comparingDouble(Emp::getSalary).reversed())
                                                .skip(1)
                                                .findFirst()
                                )
                        )
                ));

        System.out.println(secondHighestSal);
    }

    private static void highestSalaryInEachDept(List<Emp> employees) {
        //get highest sal emp for each department
        Map<String, Optional<Emp>> map = employees.stream()
                .collect(Collectors.groupingBy(Emp::getDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(Emp::getSalary))));

        System.out.println(map);

        Map<String, Emp> highestPaidPerDept = employees.stream()
                .collect(Collectors.toMap(
                        Emp::getDepartment,
                        emp -> emp,
                        (e1, e2) -> e1.getSalary() >= e2.getSalary() ? e1 : e2
                ));
        System.out.println(highestPaidPerDept);
    }

    private static void greaterThanAvgSal(List<Emp> employees) {
        double averageSalary = employees.stream()
                .mapToDouble(Emp::getSalary)
                .average()
                .orElse(0);

        List<Emp> highSalEmp = employees.stream()
                .filter(emp -> emp.getSalary() > averageSalary)
                .toList();

        System.out.println("Employees whose salary greater than average salary: " + averageSalary);
        System.out.println(highSalEmp);
    }

    private static void getEmployeeMap(List<Emp> employees) {
        Map<Long, String> empMap = employees.stream()
                .collect(Collectors.toMap(Emp::getId, Emp::getName));

        System.out.println(empMap);
    }
}
