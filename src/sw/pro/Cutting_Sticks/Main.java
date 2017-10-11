package sw.pro.Cutting_Sticks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][]    dp    = new int[101][101];
    static int[][]    ax    = new int[101][101];
    
    public static void main(String[] args) throws Exception {
        
        int l, n, i, t;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        while (l != 0) {
            // init test case
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()) + 1;
            st = new StringTokenizer(br.readLine());
            int[] c = new int[n];
            for (i = 1; i < n; i++) {
                c[i] = Integer.parseInt(st.nextToken());
            }
            // 木头的切割点的顺序可能是乱序
            // Arrays.sort(c);
            
            for (i = 1, t = 0; i < n; i++) {
                ax[i][i] = c[i] - t;
                t = c[i];
            }
            ax[i][i] = l - t;
            
            System.out.println("The minimum cutting is " + slove(1, n) + ".");
            // next test case
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            dp = new int[101][101];
            ax = new int[101][101];
        }
        br.close();
        
    }
    
    static int slove(int l, int r) {
        int i, d, j;
        for (d = 0; d <= r; d++) {
            for (i = l; i + d <= r; i++) {
                for (j = i; j + 1 <= i + d; j++) {
                    ax[i][i + d] = ax[i][j] + ax[j + 1][i + d];
                    if (dp[i][i + d] == 0) {
                        dp[i][i + d] = dp[i][j] + dp[j + 1][i + d] + ax[i][i + d];
                    } else {
                        if (dp[i][i + d] > dp[i][j] + dp[j + 1][i + d] + ax[i][i + d]) {
                            dp[i][i + d] = dp[i][j] + dp[j + 1][i + d] + ax[i][i + d];
                        }
                    }
                }
            }
        }
        return dp[l][r];
    }
}