package sw.pro.SDS_PRO_7_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class source {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] milestone = new int[N + 1];
        for (int i = 0; i < N; i++) {
            milestone[i] = Integer.parseInt(br.readLine());
        }
        milestone[milestone.length - 1] = L;
        int[] dp = new int[N + 1];
        int Max = M;
        for (int i = 1; i <= N; i++) {
            if (Max < milestone[i]) {
                Max += M;
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        System.out.println(dp[N]);
    }
}
