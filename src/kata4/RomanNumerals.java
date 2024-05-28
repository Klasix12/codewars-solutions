package kata4;

import java.util.HashMap;

public class RomanNumerals {
    public static String toRoman(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] sts = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < nums.length; i++) {
            int rpt = n / nums[i];
            stringBuilder.append(sts[i].repeat(rpt));
            n %= nums[i];
        }
        return stringBuilder.toString();
    }

    public static int fromRoman(String romanNumeral) {
        HashMap<String, Integer> romanNumerals = getStringIntegerHashMap();

        String[] rn = romanNumeral.split("");
        int result = 0;
        for (int i = 0; i < rn.length; i++) {
            if ((i + 1 < rn.length) && romanNumerals.get(rn[i]) < romanNumerals.get(rn[i + 1])) {
                result += romanNumerals.get(rn[i] + rn[i + 1]);
                i++;
            } else {
                result += romanNumerals.get(rn[i]);
            }
        }
        return result;
    }

    private static HashMap<String, Integer> getStringIntegerHashMap() {
        HashMap<String, Integer> romanNumerals = new HashMap<>();
        romanNumerals.put("M", 1000);
        romanNumerals.put("CM", 900);
        romanNumerals.put("D", 500);
        romanNumerals.put("CD", 400);
        romanNumerals.put("C", 100);
        romanNumerals.put("XC", 90);
        romanNumerals.put("L", 50);
        romanNumerals.put("XL", 40);
        romanNumerals.put("X", 10);
        romanNumerals.put("IX", 9);
        romanNumerals.put("V", 5);
        romanNumerals.put("IV", 4);
        romanNumerals.put("I", 1);
        return romanNumerals;
    }
}
