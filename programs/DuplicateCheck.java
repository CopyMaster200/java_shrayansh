package programs;

import java.util.List;
import java.util.stream.Collectors;

public class DuplicateCheck {
    public static void main(String[] args) {
        String str = "aba";
        str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> str.indexOf(c) == str.lastIndexOf(c))
                .forEach(System.out::println);

        List<Character> distinct = str.chars()
                .mapToObj(c -> (char) c)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinct);


    }
}
