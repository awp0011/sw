package sw.luogu.stage4;

import java.io.*;
import java.util.StringTokenizer;

public class P3388AC2 implements Runnable {
    static int head[];
    static int next[];
    static int to[];

    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("E:\\BaiduNetdiskDownload\\P3388_1.in"));
        new Thread(null, new P3388AC2(), "", 1 << 29).start();
    }

    @Override
    public void run() {
        mainProcess(null);
    }

    public static void init(int n, int m) {
        head = new int[n + 1];
        next = new int[2 * m + 1];
        to = new int[2 * m + 1];
    }

    static int id = 1;

    public static void add(int a, int b) {
        next[id] = head[a];
        head[a] = id;
        to[id++] = b;
    }

    public static void mainProcess(String[] args) {
        int n = IN.nextInt(), m = IN.nextInt();
        init(n, m);
        for (int i = 0; i < m; i++) {
            int a = IN.nextInt(), b = IN.nextInt();
            add(a, b);
            add(b, a);
        }
        solve(n);
    }

    public static void solve(int n) {
        dfn = new int[n + 1];
        low = new int[n + 1];
        isCut = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (dfn[i] == 0) {
                tarjan(i, -1);
            }
        }

        PrintWriter pr = new PrintWriter(System.out);
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (isCut[i]) {
                sb.append(i + " ");
                count++;
            }
        }
        pr.println(count + "\n" + sb.toString().trim());
        pr.flush();
    }

    static int dfn[];
    static int timeIdx = 1;
    static int low[];
    static boolean isCut[];

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

    static class IN {

        private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 65535);
        private static StringTokenizer st = null;

        public static String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                    break;
                }
            }
            return st.nextToken();
        }

        public static int nextInt() {
            return Integer.valueOf(next());
        }

        public static long nextLong() {
            return Long.valueOf(next());
        }

        public static void close() {
            try {
                br.close();
            } catch (IOException e) {
            }
        }
    }

}