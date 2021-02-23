package sw.luogu.stage6.SP14932;

import java.io.*;
import java.util.Arrays;

public class Main {
    private static StreamTokenizer in;
    private static PrintWriter out;
    private static final int MAX_N = 1000;
    private static final int MAX_L = (int) (Math.log(MAX_N) / Math.log(2));
    private static final int[][] p = new int[MAX_L + 1][MAX_N + 3];
    //3个数组组成了链式前向星的数据结构：head next to
    private static final int[] head = new int[MAX_N + 3];
    private static final int[] next = new int[MAX_N << 1 | 1];
    private static final int[] to = new int[MAX_N << 1 | 1];

    private static final int[] lvl = new int[MAX_N + 3];
    private static int N, M, Q, idx;


    private static void init() {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
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
            idx = 1;
            for (int a = 1; a <= N; a++) {
                int M = nextInt();
                for (int i = 0; i < M; i++) {
                    int b = nextInt();
                    addEdge(a, b);
                }
            }
            dfs(1, 0);
            for (int i = 1; i < MAX_L; i++) {
                for (int j = 1; j <= M; j++) {
                    p[i][j] = p[i - 1][p[i - 1][j]];
                }
            }
            Q = nextInt();
            out.println("Case " + tc + ":");
            for (int i = 0; i < Q; i++) {
                int a = nextInt();
                int b = nextInt();
                int lca = a == b ? a : (lvl[a] > lvl[b]) ? getLCA(a, b) : getLCA(b, a);
                out.println(lca);
            }
            out.flush();
            Arrays.fill(head, 0);
            Arrays.fill(lvl, 0);
        }
    }

    private static void addEdge(int f, int t) {
        to[idx] = t;
        next[idx] = head[f];
        head[f] = idx++;
    }

    private static void dfs(int s, int fa) {
        lvl[s] = lvl[fa] + 1;
        p[0][s] = fa;
        for (int i = head[s]; i > 0; i = next[i]) {
            if (to[i] != fa && lvl[to[i]] == 0) dfs(to[i], s);
        }
    }

    private static int getLCA(int a, int b) {
        //计算上限
        int l = 0;
        while ((1 << l) <= lvl[a]) l++;
        l--;

        //a 先向上跳，与b同一级
        for (int i = l; i >= 0; i--) {
            if ((lvl[a] - (1 << l)) >= lvl[b]) a = p[i][a];
        }
        //特判：如果a、b相等，则返回a（或b）。
        if (a == b) return a;

        //a & b 向上一起跳
        for (int i = l; i >= 0; i--) {
            if (p[i][a] != p[i][b]) {
                a = p[i][a];
                b = p[i][b];
            }
        }
        return p[0][a];
    }
}
