package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P3374 {
    private static int[] tree;

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        int offset = 1;
        while (offset < n) offset *= 2;

        tree = new int[offset * 2 + 1];
        for (int i = 0; i < n; i++) {
            in.nextToken();
            tree[offset + i] = (int) in.nval;
        }
        for (int i = offset - 1; i > 0; i--) {
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
        int t, x, y;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < m; i++) {
            in.nextToken();
            t = (int) in.nval;
            in.nextToken();
            x = (int) in.nval;
            in.nextToken();
            y = (int) in.nval;

            if (t == 1) {
                update(x + offset - 1, y);
            } else {
                ans.append(query(x + offset - 1, y + offset - 1)).append('\n');
            }
        }
        System.out.println(ans.toString());
    }

    private static void update(int pos, int dalt) {
        while (pos > 0) {
            tree[pos] += dalt;
            pos >>= 1;
        }
    }

    private static int query(int s, int e) {
        int sum = 0;
        while (s <= e) {
            if (s % 2 == 1) sum += tree[s];
            if (e % 2 == 0) sum += tree[e];
            s = (s + 1) >> 1;
            e = (e - 1) >> 1;
        }
        return sum;
    }
}
