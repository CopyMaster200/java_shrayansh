package learnjava;

/**
 * Switch Expression was introduced in java 12.
 * It doesn't have a break statement and the arrow function will return the value instead.
 * In general switch statement doesn't return any value but switch expression will return.
 */
public class SwitchExpDemo {
    public static void main(String[] args) {
        int val = 1;

        String output = switch (val) {
            case 1 -> "One";
            case 2 -> "Two";
            default -> "Default";
        };
        System.out.println(output);

        String result;
        switch (val) {
            case 1:
                result = "One";
                break;
            case 2:
                result = "Two";
                break;
            default:
                result = "default";
        }
        System.out.println(result);
    }
}
