package kata5;

import java.util.HashMap;

public class Greed {
    public static int greedy(int[] dice) {
        HashMap<Integer, Integer> dcs = new HashMap<>();
        for (int d : dice) {
            if (!dcs.containsKey(d)) {
                dcs.put(d, 0);
            }
            dcs.replace(d, dcs.get(d) + 1);
        }

        int result = 0;
        for (int key : dcs.keySet()) {
            int value = dcs.get(key);
            if (key == 1) {
                result += (value / 3 * 1000) + (value % 3 * 100);
            } else if (key == 5) {
                result += (value / 3 * 500) + (value % 3 * 50);
            } else {
                result += (value / 3 * key * 100);
            }
        }
        return result;
    }
}