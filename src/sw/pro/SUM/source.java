package sw.pro.SUM;
/*
 * 动态规划
 * 数字可重复
 * ２＋１　和１＋２　是两种不同的拆分方式
 * */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class source {
    private final static int MOD = 1_000_000_000;
    private final static long[][] middle = new long[205][205];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int end = K > N ? N : K;
        long ans = 0;
        for (int i = 0; i < end; i++) {
            ans += C(i, N - 1) * C(i + 1, K);
            ans %= MOD;
        }

        System.out.println(ans);
    }

    private static long C(int m, int n) {
        if (middle[m][n] != 0) return middle[m][n];
        if (m == 0 || n == 0 || m == n) {
            middle[m][n] = 1;
        } else if (m == 1) {
            middle[m][n] = n;
        } else {
            middle[m][n] = (C(m - 1, n - 1) + C(m, n - 1)) % MOD;
        }
        return middle[m][n];
    }
}



