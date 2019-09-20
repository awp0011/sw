package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1048 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int T = (int) in.nval;
        in.nextToken();
        int M = (int) in.nval;

        int[] times = new int[M + 3];
        int[] values = new int[M + 3];
        for (int i = 1; i <= M; i++) {
            in.nextToken();
            times[i] = (int) in.nval;
            in.nextToken();
            values[i] = (int) in.nval;
        }
        int[] dp = new int[T + 3];
        for (int i = 1; i <= M; i++) {
            for (int j = T; j >= times[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - times[i]] + values[i]);
            }
        }
        System.out.println(dp[T]);
    }
}
