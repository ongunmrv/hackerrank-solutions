import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {
    public static int diagonalDifference(List<List<Integer>> arr) {
        int x = 0;
        int y = 0;

        if (arr.size() > 0) {
            for (int i = 0; i < arr.size(); i++) {
                for (int j = 0; j < arr.size(); j++) {
                    if (i == j) {
                        x += arr.get(i).get(j);
                    }

                    if (j + i == arr.size() -1) {
                        y += arr.get(i).get(j);
                    }
                }
            }
        }

        return Math.abs(x - y);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.diagonalDifference(arr);

        System.out.println(result);
        bufferedReader.close();
    }
}