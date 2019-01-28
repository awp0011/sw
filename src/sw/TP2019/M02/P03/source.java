package sw.TP2019.M02.P03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class source {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = parseInt(st.nextToken());
        int M = parseInt(st.nextToken());
        int L = parseInt(st.nextToken());
        int sum = M;
        int ans = 0;
        int[] dp = new int[N + 3];
        for (int i = 1; i <= N; i++) {
            dp[i] = parseInt(in.readLine());
        }
        dp[N + 1] = L;
        for (int i = 1; i <= N + 1; i++) {
            if (sum < dp[i]) {
                sum = dp[i - 1] + M;
                ans++;
            }
        }
        System.out.println(ans);


    }
}
