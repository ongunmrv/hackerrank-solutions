import java.util.*;

public class Solution {
    static void plusMinus(int[] arr) {
        if (arr.length > 0) {
            int countPos = 0;
            int countNeg = 0;
            int countZero = 0;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > 0) {
                    countPos++;
                } else if (arr[i] < 0) {
                    countNeg++;
                } else {
                    countZero++;
                }
            }

            float length = arr.length;

            System.out.println(String.format("%.6f", countPos / length));
            System.out.println(String.format("%.6f", countNeg / length));
            System.out.println(String.format("%.6f",countZero / length));
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}