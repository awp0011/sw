package sw.luogu.stage6.P3372;

import java.io.*;

public class Main {
    private static StreamTokenizer in;
    private static final long[] tree = new long[300_003];
    private static final long[] tree1 = new long[300_003];
    private static int N, M, offset, cur, pre;
    private static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws IOException {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        N = nextInt();
        M = nextInt();
        offset = 1;
        while (offset <= N) offset <<= 1;
        offset--;
        pre = 0;

        for (int i = 1; i <= N; i++) {
            cur = nextInt();
            int idx = offset + i;
            tree[idx] = cur - pre;
            tree1[idx] = (i - 1) * tree[idx];
            pre = cur;
        }

        for (int i = offset; i > 0; i--) {
            tree[i] = tree[i << 1] + tree[i << 1 | 1];
            tree1[i] = tree1[i << 1] + tree1[i << 1 | 1];
        }
        for (int i = 0; i < M; i++) {
            int ord = nextInt();
            if (ord == 1) {
                int s = nextInt();
                int e = nextInt();
                int v = nextInt();
                update(s, v);
                update(e + 1, -v);
            } else {
                int x = nextInt();
                int y = nextInt();
                long ans = y * query(tree, y) - query(tree1, y);
                ans -= (x - 1) * query(tree, x - 1) - query(tree1, x - 1);
                out.println(ans);
            }
        }
        out.flush();
    }

    private static void update(int p, int val) {
        int idx = p + offset;
        int val1 = (p - 1) * val;
        while (idx > 0) {
            tree[idx] += val;
            tree1[idx] += val1;
            idx >>= 1;
        }
    }

    private static long query(long[] t, int y) {
        int s = 1 + offset;
        int e = y + offset;
        long sum = 0;
        while (s <= e) {
            if (s % 2 == 1) sum += t[s++];
            if (e % 2 == 0) sum += t[e--];
            s >>= 1;
            e >>= 1;
        }
        return sum;
    }
}