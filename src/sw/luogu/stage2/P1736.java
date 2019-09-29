package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1736 {
    private static int[][][] dp;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        dp = new int[n + 3][m + 3][2];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                in.nextToken();
                dp[i][j][0] =  (int) in.nval + dp[i][j - 1][0] + dp[i - 1][j][0];//前缀和
                dp[i][j][1] = 1;
            }
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                if (getValue(i, j) == 1 && getValue(i - 1, j - 1) == 1) {
                    int size = dp[i - 1][j - 1][1]+1;
                    if(size == getArea(size,i,j)) {
                        dp[i][j][1] = dp[i - 1][j - 1][1];
                        dp[i][j][1]++;
                        ans = Math.max(ans, dp[i][j][1]);
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j][1] = 1;
            }
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (getValue(i, j) == 1 && getValue(i - 1, j + 1) == 1) {
                    int size = dp[i - 1][j + 1][1]+1;
                    if (size == getArea(size,i,j+size)) {
                        dp[i][j][1] = dp[i - 1][j + 1][1];
                        dp[i][j][1]++;
                        ans = Math.max(ans, dp[i][j][1]);
                    }
                }

            }
        }
        System.out.println(ans);
    }

    private static int getValue(int x, int y) {
        return getArea(1, x, y);
    }

    private static int getArea(int size, int rbX, int rbY) {
        return dp[rbX][rbY][0] - dp[rbX - size][rbY][0] - dp[rbX][rbY - size][0] + dp[rbX - size][rbY - size][0];
    }
}
