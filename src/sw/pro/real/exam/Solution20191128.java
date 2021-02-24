package sw.pro.real.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Solution20191128 {
    private static StreamTokenizer in;
    private static final int MAX_N = 200000;
    private static final long[][] max = new long[2][MAX_N + 2];//每个点上两个最大值
    private static final long[][] f1 = new long[2][MAX_N + 2];//dfs下行(递归)子树和
    private static final long[][] f2 = new long[2][MAX_N + 2];//dfs上行(回溯)子树和
    private static final long[] w = new long[MAX_N + 2];//点权值

    //3个数组组成了链式前向星的数据结构：head next to
    private static final int[] head = new int[MAX_N + 3];
    private static final int[] next = new int[MAX_N << 1 | 1];
    private static final int[] to = new int[MAX_N << 1 | 1];

    private static int N, idx;

    private static void init() {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    }

    private static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws IOException {
        init();

        int T = nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = nextInt();
            for (int i = 1; i <= N; i++) {
                w[i] = nextInt();
                f2[1][i] = w[i];
                if (w[i] < 0) max[1][i] = w[i];
                else max[0][i] = w[i];
            }
            for (int i = 1; i < N; i++) {
                int a = nextInt();
                int b = nextInt();
                addEdge(a, b);
                addEdge(b, a);
            }
            dfs(1, 0);
            long ans = N == 2 ? w[1] + w[2] : Long.MIN_VALUE;
            for (int i = 1; i <= N && N > 2; i++) {
                ans = Math.max(ans, max[0][i] + max[1][i]);
            }
            System.out.println("#" + tc + " " + ans);
            Arrays.fill(max[0], 0);
            Arrays.fill(max[1], 0);
            Arrays.fill(f1[0], 0);
            Arrays.fill(f1[1], 0);
            Arrays.fill(f2[0], 0);
            Arrays.fill(f2[1], 0);
            Arrays.fill(w, 0);
            Arrays.fill(head, 0);
        }
    }

    private static void dfs(int s, int fa) {
        f1[0][s] = Math.max(w[s], f1[0][fa] + w[s]);
        f1[1][s] = Math.max(f1[0][fa], f1[1][fa]);

        sumChild(s, Math.max(f1[0][fa], f1[1][fa]));
        for (int i = head[s]; i > 0; i = next[i]) {
            if (to[i] != fa) {
                dfs(to[i], s);
                f2[0][s] = Math.max(w[s], f2[0][to[i]] + w[s]);
                f2[1][s] = Math.max(f2[0][to[i]], f2[1][to[i]]);
                sumChild(s, Math.max(f2[0][to[i]], f2[1][to[i]]));
            }
        }
    }

    private static void sumChild(int s, long ret) {
        if (w[s] < 0) {
            if (ret > max[0][s]) {//todo
                max[1][s] = max[0][s];
                max[0][s] = ret;
            } else if (ret > max[1][s]) {
                max[1][s] = ret;
            }
        } else {
            if (ret > 0) {
                max[0][s] += ret;
            } else {
                max[1][s] = Math.max(max[1][s], ret);
            }
        }
    }

    private static void addEdge(int f, int t) {
        next[idx] = head[f];
        to[idx] = t;
        head[f] = idx++;
    }

}
