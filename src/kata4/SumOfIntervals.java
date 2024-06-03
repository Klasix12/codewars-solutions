package kata4;

import java.util.Arrays;

//codewars.com/kata/52b7ed099cdc285c300001cd
public class SumOfIntervals {
    public static int sumIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        sortArrays(intervals);

        int[] prevVle = new int[]{intervals[0][0], intervals[0][1]};
        int result = 0;
        for (int i = 1; i < intervals.length; i++) {
            int firstCurrentVle = intervals[i][0];
            int secondCurrentVle = intervals[i][1];

            if (firstCurrentVle == secondCurrentVle) {
                continue;
            }

            if (prevVle[1] >= firstCurrentVle) {
                if (!(prevVle[1] > secondCurrentVle)) {
                    prevVle[1] = secondCurrentVle;
                }
            } else {
                result += prevVle[1] - prevVle[0];
                prevVle = intervals[i];
            }
        }
        result += prevVle[1] - prevVle[0];
        return result;
    }

    private static void sortArrays(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            int firstVle = a[0];
            int secondVle= b[0];
            return Integer.compare(firstVle, secondVle);
        });
    }
}
