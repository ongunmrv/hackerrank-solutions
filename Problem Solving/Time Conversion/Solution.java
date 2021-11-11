import java.io.*;
import java.util.*;

public class Solution {
    static String timeConversion(String s) {
        String hour = s.split(":")[0];

        if (hour.equals("12")) {
            hour = "00";
            s = "00" + s.substring(2);
        }

        if (s.indexOf("PM") > -1) {
            return Integer.parseInt(hour) + 12 + s.substring(2, s.length() - 2);
        } else {
            return s.substring(0, s.length() - 2);
        }
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        String s = scan.nextLine();
        String result = timeConversion(s);
        System.out.println(result);
    }
}