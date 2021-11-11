import java.util.*;

public class Solution {
    static void miniMaxSum(int[] arr) {
        int min = arr[0];
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }

            if (arr[i] > max) {
                max = arr[i];
            }
        }

        long minSum = 0;
        long maxSum = 0;
        boolean minExcluded = false;
        boolean maxExcluded = false;

        for (int i = 0; i < arr.length; i++) {
            if (!minExcluded && arr[i] == min) {
                minExcluded = true;
                continue;
            }
            maxSum += arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            if (!maxExcluded && arr[i] == max) {
                maxExcluded = true;
                continue;
            }
            minSum += arr[i];
        }

        System.out.println(minSum + " " + maxSum);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}