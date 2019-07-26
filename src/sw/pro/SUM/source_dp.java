package sw.pro.SUM;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class source_dp {
    private static final long[][] C_Data = new long[201][201];
    private static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= 200; i++) {
            C_Data[i][0] = 1;
            C_Data[i][i] = 1; }
        for (int i = 1; i <= 200; i++) {
            for (int j = 1; j <= 200; j++) {
                C_Data[i][j] = C_Data[i - 1][j - 1] + C_Data[i - 1][j];
                C_Data[i][j] %= MOD;
            }

        }
        int end = K > N ? N : K;
        long ans = 0;
        for (int i = 0; i < end; i++) {
            ans += C_Data[N - 1][i] * C_Data[K][i + 1];
            ans %= MOD;
        }
        System.out.println(ans);
    }

}
