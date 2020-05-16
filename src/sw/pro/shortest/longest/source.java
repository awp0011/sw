package sw.pro.shortest.longest;

/*
1.求多点源的任意两点的最短路径,即所有点对间的最短路径 All Pairs Shortest Path(A.P.S.P.)
  算法 Floyd
  for(int k=1;<=N;k++){
   for(int i=1;i<=N;i++){
      for(int j=1;j<=N;j++){
         map[i][j]=min(map[i][j],map[i][k]+map[k][j]);//求出所有点对间最短路径
      }
   }
 }
2.每次减少一个点和点对应的线段，求最长的最短路径
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class source {
    private static final long inf = Long.MAX_VALUE >> 1;
    private static final int MAX = 503;
    private static final boolean[] on = new boolean[MAX];
    private static final int[] off = new int[MAX];
    private static final long[] ans = new long[MAX];
    private static final long[][] dp = new long[MAX][MAX];
    private static final StringBuilder out = new StringBuilder(2000);
    private static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) off[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(on, false);
            for (int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = i + 1; j <= N; j++) {
                    int temp = Integer.parseInt(st.nextToken());
                    dp[i][j] = temp == 0 ? inf : temp;
                    dp[j][i] = dp[i][j];
                }
            }
            out.append('#').append(tc);
            for (int i = N - 1; i >= 0; i--) ans[i] = find(off[i]);
            for (int i = 0; i < N; i++) out.append(' ').append(ans[i]);
            System.out.println(out.toString());
            out.setLength(0);
        }
    }

    private static long find(int k) {//floyd
        long longest = 0;
        on[k] = true;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (dp[i][j] > dp[i][k] + dp[k][j]) dp[i][j] = dp[i][k] + dp[k][j];
                if (on[i] && on[j] && dp[i][j] > longest && dp[i][j] != inf) longest = dp[i][j];
            }
        }
        return longest;
    }
}