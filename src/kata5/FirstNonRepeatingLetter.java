package kata5;

public class FirstNonRepeatingLetter {
    public static String firstNonRepeatingLetter(String s){
        for (String l : s.split("")) {
            if (s.toLowerCase().replaceAll(l.toLowerCase(), "").length() == s.length() - 1) {
                return l;
            }
        }
        return "";
    }
}
