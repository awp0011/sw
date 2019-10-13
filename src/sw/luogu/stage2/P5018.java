package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P5018 {
    private static int[][] d;
    private static int n;

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        d = new int[n + 3][3];
        for (int i = 1; i <= n; i++) {
            in.nextToken();
            d[i][0] = (int) in.nval;
        }
        for (int i = 1; i <= n; i++) {
            in.nextToken();
            d[i][1] = (int) in.nval;
            in.nextToken();
            d[i][2] = (int) in.nval;
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (isSame(i, i)) ans = Math.max(ans, counter(i));
        }
        System.out.println(ans);
    }

    private static int counter(int s) {
        return s == -1 ? 0 : counter(d[s][1]) + counter(d[s][2]) + 1;
    }

    private static boolean isSame(int l, int r) {
        if (l == -1 && r == -1) return true;
        if (l == -1 || r == -1) return false;
        if (d[l][0] != d[r][0]) return false;
        return isSame(d[l][1], d[r][2]) && isSame(d[l][2], d[r][1]);
    }
}
