import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {
    public static int hourglassSum(List<List<Integer>> arr) {
        int sum = Integer.MIN_VALUE;
        int partialSum = sum;

        for (int x = 0; x <= 3; x++) {
            for (int y = 0; y <= 3; y++) {
                partialSum = partialHourglassSum(arr, x, y);
                if (partialSum > sum) {
                    sum = partialSum;
                }
            }
        }
        return sum;
    }

    public static int partialHourglassSum(List<List<Integer>> arr, int startX, int startY) {
        int partialSum = 0;
        int tempY = startY;

        for (int countx = 0; countx < 3; countx++) {
            for (int county = 0; county < 3; county++) {

                if ((countx == 1 && county == 0) || (countx == 1 && county == 2)) {
                    tempY++;
                    continue;
                }
                partialSum += arr.get(startX).get(tempY);
                tempY++;
            }
            tempY = startY;
            startX++;
        }

        return partialSum;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
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

        int result = Result.hourglassSum(arr);
        System.out.println(result);
        bufferedReader.close();
    }
}