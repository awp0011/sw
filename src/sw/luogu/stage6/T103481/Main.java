package sw.luogu.stage6.T103481;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main implements Runnable {
    private static StreamTokenizer in;
    private static int idx;
    private static int seq;
    private static int ans;
    private static int[] dfn, low, head, to, next;

    public static void main(String[] args)  {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        new Thread(null, new Main(), "T103481", 1 << 30).start();
    }

    private static int nextInt() {
        try {
            in.nextToken();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (int) in.nval;
    }

    @Override
    public void run() {
        int n = nextInt();
        int m = nextInt();
        idx = 1;
        seq = 1;
        ans = 0;
        dfn = new int[n + 2];
        low = new int[n + 2];
        head = new int[n + 2];
        to = new int[2 * m + 2];
        next = new int[2 * m + 2];

        for (int i = 0; i < m; i++) {
            int a = nextInt();
            int b = nextInt();
            addEdge(a, b);
            addEdge(b, a);
        }
        for (int i = 1; i <= n; i++) {
            if (dfn[i] == 0) tarjan(i, -1);
        }
        System.out.println(ans);
    }

    private static void tarjan(int cur, int fa) {
        low[cur] = dfn[cur] = seq++;
        for (int i = head[cur]; i != 0; i = next[i]) {
            int next = to[i];
            if (dfn[next] == 0) {
                tarjan(next, cur);
                low[cur] = Math.min(low[cur], low[next]);
                if (dfn[cur] < low[next] && cur != next) ans++;
            } else if (next != fa && dfn[cur] > dfn[next]) {
                low[cur] = Math.min(low[cur], dfn[next]);
            }
        }

    }

    private static void addEdge(int a, int b) {
        next[idx] = head[a];
        head[a] = idx;
        to[idx++] = b;
    }

}
