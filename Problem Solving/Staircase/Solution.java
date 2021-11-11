import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static void staircase(int n) {
        if (n > 1) {
            int countSpace = n -1;
            int countSign = 1;
            int countSpaceTemp;
            int countSignTemp;

            while(countSpace >= 0 && countSign <= n) {
                countSpaceTemp = countSpace;
                countSignTemp = countSign;
                while (countSpaceTemp > 0) {
                    System.out.print(" ");
                    countSpaceTemp--;
                }

                while (countSignTemp >= 1) {
                    System.out.print("#");
                    countSignTemp--;
                }

                if (countSpace != 0) {
                    System.out.println();
                }
                countSpace--;
                countSign++;
            }
        } else {
            System.out.print("#");
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}