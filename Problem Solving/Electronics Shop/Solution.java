import java.io.*;
import java.util.*;

public class Solution {
    static int getMoneySpent(int[] keyboards, int[] drives, int budget) {
        Arrays.sort(keyboards);
        Arrays.sort(drives);

        int cost = 0;

        for (int i = keyboards.length - 1; i >= 0; i--) {
            if (keyboards[i] >= budget) {
                continue;
            }

            for (int j = drives.length - 1; j >= 0; j--) {
                if (drives[j] + keyboards[i] <= budget && drives[j] + keyboards[i] > cost) {
                    cost = drives[j] + keyboards[i];
                }
            }
        }

        return cost != 0 ? cost : -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] bnm = scanner.nextLine().split(" ");

        int b = Integer.parseInt(bnm[0]);

        int n = Integer.parseInt(bnm[1]);

        int m = Integer.parseInt(bnm[2]);

        int[] keyboards = new int[n];

        String[] keyboardsItems = scanner.nextLine().split(" ");

        for (int keyboardsItr = 0; keyboardsItr < n; keyboardsItr++) {
            int keyboardsItem = Integer.parseInt(keyboardsItems[keyboardsItr]);
            keyboards[keyboardsItr] = keyboardsItem;
        }

        int[] drives = new int[m];

        String[] drivesItems = scanner.nextLine().split(" ");

        for (int drivesItr = 0; drivesItr < m; drivesItr++) {
            int drivesItem = Integer.parseInt(drivesItems[drivesItr]);
            drives[drivesItr] = drivesItem;
        }

        int moneySpent = getMoneySpent(keyboards, drives, b);

        System.out.println(moneySpent);

        scanner.close();
    }
}