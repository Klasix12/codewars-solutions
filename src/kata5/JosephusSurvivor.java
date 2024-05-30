package kata5;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Josephus Survivor solution
public class JosephusSurvivor {
    public static int josephusSurvivor(final int n, final int k) {
        ArrayList<Integer> nl = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toCollection(ArrayList::new));
        int cursor = 1;
        int index = 0;
        while (true) {
            if (nl.size() == 1) {
                return nl.get(0);
            }
            if (index >= nl.size()) {
                index = 0;
            }
            if (cursor % k == 0) {
                nl.remove(index);
                index--;
            }
            index++;
            cursor++;
        }
    }
}
