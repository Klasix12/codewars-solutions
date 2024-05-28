package kata6;

class Persist {
    public static int persistence(long n) {
        if (n < 10) {
            return 0;
        }
        int count = 0;

        while (true) {
            long temp = 1;
            while (n != 0) {
                temp *= n % 10;
                n /= 10;
            }
            count++;
            if (temp < 10) {
                break;
            }
            n = temp;
        }
        return count;
    }
}
