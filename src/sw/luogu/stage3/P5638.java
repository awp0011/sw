package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P5638 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int k = (int) in.nval;
        long[] d = new long[n + 1];
        long t = 0, r = 0, s = 0;
        for (int i = 1; i < n; i++) {
            in.nextToken();
            d[i] = (long) in.nval;
            t += d[i];
            r += d[i];
            if (k > 0 && i >= k) {
                r -= d[i - k];
                s = Math.max(s, r);
            }
        }
        System.out.println(t - s);
    }
}
