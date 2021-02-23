package sw.pro.real.exam;

import java.awt.datatransfer.FlavorEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Solution20210222_ola {
    private static StreamTokenizer in;
    private static final int MAX_N = 300000;
    private static final int[] tree = new int[MAX_N * 6];
    private static final int[] euler = new int[MAX_N + 3];
    private static final int[] lca = new int[MAX_N + 3];
    private static final int[] p = new int[MAX_N + 3];
    //3个数组组成了链式前向星的数据结构：head next to
    private static final int[] head = new int[MAX_N + 3];
    private static final int[] next = new int[MAX_N << 1 | 1];
    private static final int[] to = new int[MAX_N << 1 | 1];

    private static final int[] lvl = new int[MAX_N + 3];
    private static int N, D, idx, seq, offset;

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
            D = nextInt();
            idx = 1;
            for (int a = 1; a <= N; a++) {
                int b = nextInt();
                addEdge(a, b);
                addEdge(b, a);
            }
            offset = 1;
            while (offset <= N) offset <<= 1;
            offset--;

            seq = 1;
            idx = 1;
            dfs(1, 0);
            for (int i = offset; i > 0; i--) {
                tree[i] = Math.min(tree[i << 1], tree[i << 1 | 1]);
            }
            int min = Integer.MAX_VALUE;
            int mid = 0;
            for (int i = 0; i < D && min != 0; i++) {
                int a = nextInt();
                int b = nextInt();
                if (a == b) {
                    min = 0;
                    mid = a;
                } else {
                    int lca = getLCA(a, b);
                    int len = lvl[a] + lvl[b] - (lvl[lca] << 1);
                    if (len % 2 == 0 && min > (len >> 1)) {
                        min = len >> 1;
                        mid = lvl[a] > lvl[b] ? getMeet(a, min) : getMeet(b, min);
                    }
                }

            }
            if (min == Integer.MAX_VALUE) System.out.println("#" + tc + " -1");
            else System.out.println("#" + tc + " " + mid + " " + min);
            Arrays.fill(head, 0);
            Arrays.fill(lvl, 0);
            Arrays.fill(euler, 0);
            Arrays.fill(tree, 0);
            Arrays.fill(lca, 0);
        }
    }


    private static void addEdge(int f, int t) {
        next[idx] = head[f];
        to[idx] = t;
        head[f] = idx++;
    }


    private static void dfs(int c, int fa) {
        lvl[c] = lvl[fa] + 1;
        p[c] = fa;
        for (int i = head[c]; i > 0; i = next[i]) {
            if (fa != to[i]) {
                if (euler[c] == 0) {
                    euler[c] = idx++;
                    lca[euler[c]] = c;
                }
                tree[seq++] = euler[c];
                dfs(to[i], c);
                tree[seq++] = euler[c];
            }
        }
    }

    private static int getMeet(int a, int up) {
        int meet = p[a];
        up--;
        while (up > 0) {
            meet = p[meet];
            up--;
        }
        return meet;
    }

    private static int getLCA(int a, int b) {
        int min = Integer.MAX_VALUE;
        int s, e;
        if (euler[a] < offset + euler[b]) {
            s = offset + euler[a];
            e = offset + euler[b];
        } else {
            s = offset + euler[b];
            e = offset + euler[a];
        }
        while (s <= e) {
            if (s % 2 == 1) min = Math.min(min, tree[s]);
            if (e % 2 == 0) min = Math.min(min, tree[e]);
            s = (s + 1) >> 1;
            e = (e - 1) >> 1;
        }
        return lca[min];
    }
}
