package sw.pro.real.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;


public class Solution20210125S {
    private static StreamTokenizer in;
    private static int idx, seq, m, pos = 0;
    private static int[][] map = new int[505][505];
    private static int[] ans = new int[5];
    private static int[] dfn = new int[250005];
    private static int[] low = new int[250005];
    private static int[] cnt = new int[250005];
    private static int[] head = new int[250005];
    private static int[] to = new int[1000000];
    private static int[] next = new int[1000000];
    private static int[][] stack = new int[2][250000];

    public static void main(String[] args) {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        int T = nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int n = nextInt();
            m = nextInt();
            int max = n * m;
            idx = seq = 1;

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    map[i][j] = nextInt();
                    int a = i * m + j;
                    int b = i * m + (j - 1);
                    if (map[i][j] == map[i][j - 1]) {
                        addEdge(a, b);
                        addEdge(b, a);
                    }
                    int c = (i - 1) * m + j;
                    if (map[i][j] == map[i - 1][j]) {
                        addEdge(a, c);
                        addEdge(c, a);
                    }
                }
            }
            for (int i = 1; i <= n; i++) if (dfn[i] == 0) tarjan(i);
            for (int i = 1; i <= max; i++) ans[cnt[i]]++;
            System.out.println("#" + tc + " " + ans[2] + " " + ans[3] + " " + ans[4]);

            Arrays.fill(dfn, 0, max + 1, 0);
            Arrays.fill(low, 0, max + 1, 0);
            Arrays.fill(cnt, 0, max + 1, 0);
            Arrays.fill(head, 0, max + 1, 0);
            Arrays.fill(to, 0, 2 * m + 1, 0);
            Arrays.fill(next, 0, 2 * m + 1, 0);
            Arrays.fill(ans, 0);
            for (int i = 1; i <= n; i++) Arrays.fill(map[i], 0);
        }
    }

    private static int nextInt() {
        try {
            in.nextToken();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (int) in.nval;
    }

    private static void tarjan(int cur) {
        push(cur);
        while (pos != 0) {
            if (stack[1][pos] == 0) {
                pos--;//pop
                low[stack[0][pos]] = Math.min(low[stack[0][pos]], low[stack[0][pos + 1]]);
                if (dfn[stack[0][pos]] < low[stack[0][pos + 1]]) {
                    cnt[stack[0][pos]]++;
                    cnt[stack[0][pos + 1]]++;
                }
            } else {
                int nt = to[stack[1][pos]];
                stack[1][pos] = next[stack[1][pos]];
                if (dfn[nt] == 0) {
                    push(nt);
                } else if (nt != stack[0][pos - 1] && dfn[stack[0][pos]] > dfn[nt]) {
                    low[stack[0][pos]] = Math.min(low[stack[0][pos]], dfn[nt]);
                }
            }
        }
    }

    private static void push(int cur) {
        pos++;
        stack[0][1] = cur;
        stack[1][1] = head[cur];
        low[cur] = dfn[cur] = seq++;
    }

    private static void addEdge(int a, int b) {
        next[idx] = head[a];
        head[a] = idx;
        to[idx++] = b;
    }

}
