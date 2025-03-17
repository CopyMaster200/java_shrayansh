package test.oracle;

public class StringReducer {
    public static String reduceString(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            sb.append(c);

            int len = sb.length();
            if (len >= 2) {
                String lastTwo = sb.substring(len - 2);
                if (lastTwo.equals("AB") || lastTwo.equals("BB")) {
                    sb.setLength(len - 2); // Remove last two characters
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "AABBBBBBA";
        String result = reduceString(input);
        System.out.println("Reduced String: " + result);
    }
}

