import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class Solution {
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int scoreA = 0;
        int scoreB = 0;
        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i)) {
                scoreA++;
            } else if (a.get(i) < b.get(i)) {
                scoreB++;
            }
        }
        result.add(scoreA);
        result.add(scoreB);

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = compareTriplets(a, b);
        System.out.println(result);

        bufferedReader.close();
    }
}