package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1268 {
    private static final int[][] tree = new int[31][31];

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int N = (int) in.nval;
        while (N != 0) {
            for (int i = 1; i <= N; i++) {
                for (int j = i + 1; j <= N; j++) {
                    if (i == j) continue;
                    in.nextToken();
                    tree[i][j] = (int) in.nval;
                }
            }
            System.out.println(cal(N));
            in.nextToken();
            N = (int) in.nval;
        }
    }

    private static int cal(int n) {
        int ans = tree[1][2], sig;
        for (int i = 3; i <= n; i++) {
            sig = Integer.MAX_VALUE;
            for (int j = 1; j < i; j++) {
                for (int k = j + 1; k < i; k++) {
                    sig = Integer.min(sig, (tree[j][i] + tree[k][i] - tree[j][k]) >> 1);
                }
            }
            ans += sig;
        }
        return ans;
    }
}
