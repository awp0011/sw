package sw.luogu.stage4;

import java.io.*;

public class P3388 implements Runnable {
    private static int idx;
    private static int timeIdx;
    private static int[] head, next, to, low, dfn;
    private static boolean[] isCut;
    private static StreamTokenizer in;

    public static void main(String[] args) {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        new Thread(null, new P3388(), "", 1 << 29).start();
    }

    @Override
    public void run() {
        int n = nextInt();
        int m = nextInt();

        head = new int[n + 2];
        dfn = new int[n + 2];
        low = new int[n + 2];
        isCut = new boolean[n + 2];
        next = new int[2 * m + 2];
        to = new int[2 * m + 2];
        idx = 1;
        timeIdx = 1;

        for (int i = 0; i < m; i++) {
            int a = nextInt();
            int b = nextInt();
            addEdge(a, b);
            addEdge(b, a);
        }
        for (int i = 1; i <= n; i++) {
            if (dfn[i] == 0) {
                tarjan(i, -1);
            }
        }

        int cnt = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (isCut[i]) {
                cnt++;
                ans.append(i).append(' ');
            }
        }
        System.out.println(cnt);
        System.out.println(ans.toString());

    }


    public static void tarjan(int cur, int fa) {
        low[cur] = dfn[cur] = timeIdx++;
        int count = 0;
        for (int i = head[cur]; i != 0; i = next[i]) {
            int next = to[i];
            if (dfn[next] == 0) {
                count++;
                tarjan(next, cur);
                low[cur] = Math.min(low[cur], low[next]);
                if (dfn[cur] <= low[next]) {
                    if (cur != next) {
                        isCut[cur] = true;
                    }
                }
            } else if (next != fa && dfn[cur] > dfn[next]) {
                low[cur] = Math.min(low[cur], dfn[next]);
            }
        }
        if (fa < 0 && count == 1) {
            isCut[cur] = false;
        }
    }

    public static void addEdge(int a, int b) {
        next[idx] = head[a];
        head[a] = idx;
        to[idx++] = b;
    }

    private static int nextInt() {
        try {
            in.nextToken();
            return (int) in.nval;
        } catch (IOException e) {
            e.printStackTrace();
            return Integer.MIN_VALUE;
        }
    }

}
