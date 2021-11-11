import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        int lastAnswer = 0;
        int type, x, y;
        int index;
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> table = new HashMap<Integer, List<Integer>>();
        List<Integer> current;

        for (int i = 0; i < queries.size(); i++) {
            type = queries.get(i).get(0);
            x = queries.get(i).get(1);
            y = queries.get(i).get(2);
            index = ((x ^ lastAnswer) % n);
            current = table.get(index);

            if (type == 1) {
                if (current == null) {
                    current = new ArrayList<>();
                }

                current.add(current.size(), y);
                table.put(index, current);
            } else if (type == 2) {
                lastAnswer = current.get(y % current.size());
                result.add(lastAnswer);
            }
        }

        return result;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            String[] queriesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> queriesRowItems = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowTempItems[j]);
                queriesRowItems.add(queriesItem);
            }

            queries.add(queriesRowItems);
        }

        List<Integer> result = Result.dynamicArray(n, queries);

        for (int i = 0; i < result.size(); i++) {
            System.out.println((result.get(i)));

            if (i != result.size() - 1) {
                System.out.println("\n");
            }
        }
        bufferedReader.close();
    }
}