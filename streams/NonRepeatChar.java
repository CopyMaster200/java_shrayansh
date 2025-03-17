package test.streams;

public class NonRepeatChar {
    public static void main(String[] args) {
        String input = "swiss";
        Character result = input.chars()
                .mapToObj(x -> (char) x)
                .filter(x -> input.indexOf(x) == input.lastIndexOf(x))
                .limit(1)
                .findFirst()
                .orElse(null);
        System.out.println(result);
    }
}
