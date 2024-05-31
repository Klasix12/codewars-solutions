package kata5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


// codewars.com/kata/5279f6fe5ab7f447890006a7
public class PickPeaks {
    public static Map<String, List<Integer>> getPeaks(int[] arr) {
        Map<String, List<Integer>> result = new HashMap<>();
        result.put("pos", new ArrayList<>());
        result.put("peaks", new ArrayList<>());

        int peak = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i - 1] < arr[i]) {
                peak = arr[i];
                for (int j = i; j < arr.length; j++) {
                    if (peak > arr[j]) {
                        result.get("pos").add(i);
                        result.get("peaks").add(peak);
                        break;
                    }
                    if (peak < arr[j]) {
                        break;
                    }
                }
            }
        }
        return result;
    }
}