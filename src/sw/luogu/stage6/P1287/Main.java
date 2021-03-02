package sw.luogu.stage6.P1287;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int[][] f = new int[12][12];
    static final int[] s = new int[12];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        System.out.println(F(n, r) * fac(r));
    }

    private static int F(int i, int j) {
        if (i < j) return 0;
        if (f[i][j] > 0) return f[i][j];
        if (j == 1) return f[i][j] = 1;
        return f[i][j] = F(i - 1, j - 1) + j * F(i - 1, j);
    }

    private static int fac(int i) {
        if (i == 0) return 1;
        if (s[i] > 0) return s[i];
        return i * fac(i - 1);
    }
}
