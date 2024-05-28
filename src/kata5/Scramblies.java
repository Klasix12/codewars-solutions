package kata5;

import java.util.HashMap;

public class Scramblies {
    public static boolean scramble(String str1, String str2) {
        HashMap<String, Integer> str1HashMap = getHashMapFromString(str1);
        HashMap<String, Integer> str2HashMap = getHashMapFromString(str2);
        for (String key : str2HashMap.keySet()) {
            if (str1HashMap.getOrDefault(key, 0) < str2HashMap.get(key)) {
                return false;
            }
        }
        return true;
    }

    private static HashMap<String, Integer> getHashMapFromString(String str) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String s : str.split("")) {
            if (!hashMap.containsKey(s)) {
                hashMap.put(s, 0);
            }
            hashMap.replace(s, hashMap.get(s) + 1);
        }
        return hashMap;
    }
}