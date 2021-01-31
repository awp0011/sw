package sw.luogu.stage4;

import java.io.*;
import java.util.*;

// written by luchy0120

public class P3388AC {
    private static long start;

    public static void main(String[] args) throws IOException {
        start = System.currentTimeMillis();
        new P3388AC().run();
    }


    int[] child;
    int[] color;
    int[] dfn;
    int[] low;
    int[] stack;
    int[] cnt;
    boolean[] iscut;
    int deep, n, m;
    int root = 0;

    //  无向图的强连通分量
    void tarjanNonDirect(int u1) {

        int[] stk = new int[10001];
        int[] fatk = new int[10001];
        int p = 0;
        stk[p] = u1;
        fatk[p] = -1;
        p = 1;
        ot:
        while (p > 0) {
            int u = stk[p - 1];
            int fa = fatk[p - 1];

            if (dfn[u] == 0) {
                low[u] = dfn[u] = ++deep;
            }

            for (; h[u] != -1; h[u] = ne[h[u]]) {
                int v = to[h[u]];
                if (dfn[v] == 0) {
                    fatk[p] = u;
                    stk[p++] = v;
                    continue ot;
                } else {
                    low[u] = Math.min(low[u], dfn[v]);
                    // 没有特判是否直接指向父亲
                    // 回边，使用dfn【v】更新low【u】,因为可能是指向父亲，而父亲的low可能比较小
                }
            }
            --p;

            if (fa != -1) {
                low[fa] = Math.min(low[fa], low[u]);
                if (low[u] >= dfn[fa]) {
                    if (fa != root || ++child[fa] > 1) {     // 不是root，直接记为cut，是root，判断是否有两个儿子
                        iscut[fa] = true;
                    }
                }
            }
        }
    }

    int gd = 0;

    int[] h;
    int[] to;
    int[] ne;
    int ct = 0;

    void add(int u, int v) {
        // u--;v--;
        to[ct] = v;
        ne[ct] = h[u];
        h[u] = ct++;

    }


    void solve() {
        n = ni();
        m = ni();
        color = new int[n + 1];
        dfn = new int[n + 1];
        low = new int[n + 1];
        stack = new int[n + 1];
        cnt = new int[n + 1];
        iscut = new boolean[n + 1];
        h = new int[n + 1];
        Arrays.fill(h, -1);
        to = new int[m * 2];
        ne = new int[m * 2];
        child = new int[n + 1];


        for (int i = 0; i < m; ++i) {
            int x = ni();
            int y = ni();
            add(x, y);
            add(y, x);
        }

        for (int i = 1; i <= n; ++i) {
            if (dfn[i] == 0) {
                root = i;
                tarjanNonDirect(i);
            }
        }


        for (int i = 1; i <= n; ++i) {
            if (iscut[i]) {
                gd++;
            }
        }
        println(gd);
        for (int i = 1; i <= n; ++i) {
            if (iscut[i]) {
                print(i + " ");
            }
        }


    }

    InputStream is;
    PrintWriter out;

    void run() throws FileNotFoundException {
        System.setIn(new FileInputStream("E:\\BaiduNetdiskDownload\\P3388_1.in"));

        is = System.in;
        out = new PrintWriter(System.out);
        solve();
        out.println("Time:" + (System.currentTimeMillis() - start));
        out.flush();
    }

    private final byte[] inbuf = new byte[1024];
    public int lenbuf = 0, ptrbuf = 0;

    private int readByte() {
        if (lenbuf == -1) throw new InputMismatchException();
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0) return -1;
        }
        return inbuf[ptrbuf++];
    }

    private boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    private int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b)) ;
        return b;
    }


    private int ni() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) {
        }
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        while (true) {
            if (b >= '0' && b <= '9') num = (num << 3) + (num << 1) + (b - '0');
            else return minus ? -num : num;
            b = readByte();
        }
    }

    void print(Object obj) {
        out.print(obj);
    }

    void println(Object obj) {
        out.println(obj);
    }


}