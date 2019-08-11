package sw.luogu;

import java.util.Arrays;

public class P1008 {
    private static final boolean[] USED = new boolean[10];

    public static void main(String[] args) {
        for (int i = 123; i < 333; i++) {
            Arrays.fill(USED, false);
            USED[0] = true;
            if (isUsed(i)) continue;
            int j = i * 2;
            if (isUsed(j)) continue;
            int k = i * 3;
            if (isUsed(k)) continue;
            System.out.println(i + " " + j + " " + k);
        }
    }

    private static boolean isUsed(int n) {
        do {
            int t = n % 10;
            if (USED[t]) {
                return true;
            } else {
                USED[t] = true;
                n /= 10;
            }
        }
        while (n > 0);
        return false;
    }

}
