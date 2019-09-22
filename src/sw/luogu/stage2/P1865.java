package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1865 {
    private static int[] sum, vis;

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int N = (int) in.nval;
        in.nextToken();
        int M = (int) in.nval;
        E(M);
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < N; i++) {
            in.nextToken();
            int l = (int) in.nval;
            in.nextToken();
            int r = (int) in.nval;
            if (l < 1 || l > M || r < 1 || r > M) ans.append("Crossing the line").append('\n');
            else ans.append(sum[r] - sum[l - 1]).append('\n');
        }
        System.out.print(ans.toString());
    }

    private static void E(int m) {
        sum = new int[m + 3];
        vis = new int[m + 3];
        for (int i = 2; i <= m; i++) {
            if (vis[i] == 0) {//质数
                sum[i] = sum[i - 1] + 1;
                for (int j = i << 1; j <= m; j += i) {
                    vis[j] = 1;
                }
            } else {//不是质数
                sum[i] = sum[i - 1];
            }
        }
    }
}
