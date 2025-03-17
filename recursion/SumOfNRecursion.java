package recursion;

public class SumOfNRecursion {
    public static void main(String[] args) {
        int sum = 0;
//        sumOfN(3, sum);
        System.out.println(sumOfN(3));
    }

    private static void sumOfN(int i, int sum) {
        if (i < 1) {
            System.out.println(sum);
            return;
        }
        else {
            sumOfN(i-1, sum+i);
        }
    }

    private static int sumOfN(int i) {
        int sum = 0;
        if (i < 1) {
            return sum;
        }
        else {
            sum += i;
            sumOfN(i-1);
        }
        return sum;
    }
}
