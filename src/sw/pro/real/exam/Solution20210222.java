package sw.pro.real.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Solution20210222 implements Runnable {
    private static StreamTokenizer in;
    private static final int MAX_N = 300000;
    private static final int MAX_L = (int) (Math.log(MAX_N) / Math.log(2));
    private static final int[][] p = new int[MAX_L + 1][MAX_N + 3];
    //3个数组组成了链式前向星的数据结构：head next to
    private static final int[] head = new int[MAX_N + 3];
    private static final int[] next = new int[MAX_N << 1 | 1];
    private static final int[] to = new int[MAX_N << 1 | 1];

    private static final int[] lvl = new int[MAX_N + 3];
    private static int N, D, idx;

    private static void init() {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    }

    private static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws IOException {
        init();
        new Thread(null, new Solution20210222(), "", 1024 * 1024 * 25).start();
    }

    @Override
    public void run() {
        try {
            int T = nextInt();
            for (int tc = 1; tc <= T; tc++) {
                N = nextInt();
                idx = 1;
                for (int a = 1; a <= N; a++) {
                    int b = nextInt();
                    addEdge(a, b);
                    addEdge(b, a);
                }
                dfs(1, 0);

                for (int i = 1; i <= MAX_L; i++) {
                    for (int j = 1; j <= MAX_N; j++) {
                        p[i][j] = p[i - 1][p[i - 1][j]];
                    }
                }
                int min = Integer.MAX_VALUE;
                int mid = 0;
                for (int i = 0; i < D; i++) {
                    int a = nextInt();
                    int b = nextInt();
                    int lca = lvl[a] > lvl[b] ? getLCA(a, b) : getLCA(b, a);
                    int len = lvl[a] + lvl[b] - (lvl[lca] << 1);
                    if (len % 2 == 0 && min > (len >> 1)) {
                        min = len >> 1;
                        mid = lvl[a] > lvl[b] ? getMeet(a, min) : getMeet(b, min);
                    }
                }
                if (min == Integer.MAX_VALUE) System.out.println("#" + tc + " -1");
                else System.out.println("#" + tc + " " + min + " " + mid);
                Arrays.fill(head, 0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void addEdge(int f, int t) {
        next[idx] = head[f];
        to[idx] = t;
        head[f] = idx++;
    }


    private static void dfs(int c, int fa) {
        lvl[c] = lvl[fa] + 1;
        p[0][c] = fa;
        for (int i = head[c]; i > 0; i = next[i]) {
            if (fa != to[i]) dfs(to[i], c);
        }
    }

    private static int getMeet(int a, int up) {
        int meet = p[0][a];
        up--;
        while (up > 0) {
            meet = p[0][meet];
            up--;
        }
        return meet;
    }

    private static int getLCA(int a, int b) {
        //先计算上限
        int cnt = 0;
        while ((1 << cnt) <= lvl[a]) cnt++;
        cnt--;

        //a 先向上跳，与b同一级
        for (int i = cnt; i >= 0; i--) {
            if (lvl[a] - (1 << i) >= lvl[b]) a = p[i][a];
        }

        //特判：如果a、b相等，则返回a（或b）。
        if (a == b) return a;
        for (int i = cnt; i >= 0; i--) {
            if (p[i][a] != p[i][b]) {
                a = p[i][a];
                b = p[i][b];
            }

        }
        return p[0][a];//返回a（或b）的父亲
    }
}
