package sw.pro.SET;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class source {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] a = new int[N + 1];
        int[] b = new int[M + 1];


        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int[][] dp = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = dp[i - 1][j - 1] + Math.abs(a[i] - b[j]);
                if (i < j && dp[i][j] > dp[i][j - 1]) {
                    dp[i][j] = dp[i][j - 1];
                }
                if (i > j && dp[i][j] > dp[i - 1][j]) {
                    dp[i][j] = dp[i - 1][j];
                }
                //System.out.print(dp[i][j] + " ");
            }
            // System.out.println();
        }
        System.out.println(dp[N][M]);
        br.close();
    }
}
