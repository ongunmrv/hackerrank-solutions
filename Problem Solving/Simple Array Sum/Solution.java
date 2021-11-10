import java.io.IOException;
import java.util.Scanner;

public class Solution {
    static int simpleArraySum(int[] ar) {
        int sum = 0;

        for (int i = 0 ; i < ar.length; i++) {
            sum += ar[i];
        }

        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int arCount = Integer.parseInt(scanner.nextLine().trim());

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");

        for (int arItr = 0; arItr < arCount; arItr++) {
            int arItem = Integer.parseInt(arItems[arItr].trim());
            ar[arItr] = arItem;
        }

        int result = simpleArraySum(ar);
        System.out.println(String.valueOf(result));

    }
}