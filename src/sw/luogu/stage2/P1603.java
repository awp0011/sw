package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1603 {
    private static final int[] H = new int[]{110182, 115276, 110339486,
            3149094, 3143346, 113890, 109330445, 96505999, 3381426,
            114717, -1300557247, -860970343, 1228536567, 565136640, -860088995,
            2104147644, -1420708761, 1677195487, 380252812, -860968463, 97,
            3029889, -851179773, 97440432, -906279820, 110331239};
    private static final int[] N = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 1, 2, 1, 1, 2, 3};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] T = new int[6];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < 5; i++) {
            int h = s[i].hashCode();
            for (int j = 0; j < H.length; j++) {
                if (H[j] == h) {
                    T[i] = (N[j] * N[j]) % 100;
                    break;
                }
            }
        }
        int h = s[5].endsWith(".") ? s[5].substring(0, s[5].length() - 1).hashCode() : s[5].hashCode();
        for (int j = 0; j < H.length; j++) if (H[j] == h) T[5] = (N[j] * N[j]) % 100;
        Arrays.sort(T);
        long ans = 0;
        for (int i : T) ans = (ans + i) * 100;
        System.out.println(ans / 100);

    }
}
