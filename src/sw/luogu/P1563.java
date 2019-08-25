package sw.luogu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1563 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;

        int[] d = new int[n + 1];
        String[] a = new String[n + 1];
        for (int i = 1; i <= n; i++) {
            in.nextToken();
            d[i] = (int) in.nval;
            in.nextToken();
            a[i] = in.sval;
        }
        int[][] offset = new int[][]{{-1, 1}, {1, -1}};
        int ans = 1;
        for (int i = 0; i < m; i++) {
            in.nextToken();
            int ai = (int) in.nval;
            in.nextToken();
            int si = (int) in.nval;
            if (offset[d[ans]][ai] == 1) ans += si;
            else ans -= si;
            if (ans < 1) ans += n;
            else if (ans > n) ans %= n;

        }
        System.out.println(a[ans]);
    }
}
