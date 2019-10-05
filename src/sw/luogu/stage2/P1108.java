package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class P1108 {
    private static int[] tree;

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int[][] d = new int[n][2];
        for (int i = 0; i < n; i++) {
            d[i][0] = i;
            in.nextToken();
            d[i][1] = (int) in.nval;
        }
        System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        Arrays.sort(d, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] == o1[1] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });
        int offset = 1;
        while (offset < n) offset *= 2;
        tree = new int[2 * offset];
        int max = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            int m = query(offset, offset + d[i][0]) + 1;
            if (m > max) {
                max = m;
                cnt = 1;
            } else if (m == max) {
                cnt++;
            }
            update(offset + d[i][0], m);
        }
        System.out.println(max + " " + cnt);
    }

    private static int query(int s, int e) {
        int max = 0;
        while (s <= e) {
            if (s % 2 == 1) max = Math.max(max, tree[s]);
            if (e % 2 == 0) max = Math.max(max, tree[e]);
            s = (s + 1) >> 1;
            e = (e - 1) >> 1;
        }
        return max;
    }

    private static void update(int i, int v) {
        while (i > 0) {
            tree[i] = Math.max(tree[i], v);
            i >>= 1;
        }
    }
}
