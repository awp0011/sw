package sw.pro.IndexedTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class source {
    private static final long[] tree = new long[300000];

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int N = (int) in.nval;
        int offset = 1;
        while (offset < N) offset *= 2;
        offset--;
        in.nextToken();
        int M = (int) in.nval;

        for (int i = 1; i <= N; i++) tree[offset + i] = i;
        for (int i = offset; i > 0; i--) tree[i] = tree[i * 2] + tree[i * 2 + 1];
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < M; i++) {
            in.nextToken();
            int c = (int) in.nval;
            in.nextToken();
            int x = (int) in.nval;

            if (c == 1) {
                in.nextToken();
                int y = (int) in.nval;
                if (x == y) {
                    ans.append(tree[offset + x]).append('\n');
                } else {
                    ans.append(query(offset + x, offset + y)).append('\n');
                }
            } else {
                in.nextToken();
                long y = (long) in.nval;
                update(offset + x, y - tree[offset + x]);
                tree[offset + x] = y;
            }
        }
        System.out.println(ans.toString());

    }

    private static long query(int x, int y) {
        long ret = 0;
        if (x % 2 == 1) {
            ret += tree[x];
            x++;
        }
        if (y % 2 == 0) {
            ret += tree[y];
            y--;
        }
        while (x != y) {
            x >>= 1;
            y >>= 1;
        }
        ret += tree[x];
        return ret;
    }

    private static void update(int pos, long diff) {
        while (pos > 0) {
            tree[pos] += diff;
            pos >>= 1;
        }
    }

}
