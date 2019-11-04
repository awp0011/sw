package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Random;

public class P1541random {
    private static final Random r = new Random();

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;

        int[] L = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            in.nextToken();
            L[i] = (int) in.nval;
        }
        int[] C = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            in.nextToken();
            C[i] = (int) in.nval;
        }
        int ans = 0;
        for (int i = 0; i < 100000; i++) {

            int sum = L[1], len = 1;
            for (int j = 1; j <= m; j++) {
                len += C[j];
                sum += L[len];
            }
            if (sum > ans) ans = sum;
            swap(C, m);
        }
        System.out.println(ans);
    }

    private static void swap(int[] c, int m) {
        for (int i = 1; i < c.length; i++) {
            int n = r.nextInt(m) + 1;
            int tmp = c[i];
            c[i] = c[n];
            c[n] = tmp;
        }
    }
}
