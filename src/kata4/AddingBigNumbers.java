package kata4;

public class AddingBigNumbers {
    public static String add(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int maxLength = Math.max(a.length(), b.length());
        b = "0".repeat(maxLength - b.length()) + b;
        a = "0".repeat(maxLength - a.length()) + a;

        boolean addOne = false;
        for (int i = b.length() - 1; i >= 0; i--) {
            int vle = Character.getNumericValue(a.charAt(i)) + Character.getNumericValue(b.charAt(i));
            if (addOne) {
                vle += 1;
                addOne = false;
            }
            if (vle >= 10) {
                addOne = true;
                sb.append(vle % 10);
            } else {
                sb.append(vle);
            }
        }
        if (addOne) {
            sb.append("1");
        }

        while (sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.reverse().toString();
    }
}
