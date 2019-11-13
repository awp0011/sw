package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class P1091 {
    private static final int[] tree = new int[300];
    private static final int[][] data = new int[103][4];
    private static final HashSet<Integer> is = new HashSet<>();

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int index = 0;
        for (int i = 0; i < n; i++) {
            in.nextToken();
            data[index][0] = index;
            data[index][1] = (int) in.nval;
            if (is.contains(data[index][1])) index--;
            else is.add(data[index][1]);
            index++;
        }
        int dup = n - is.size();
        n = is.size();
        int offset = 1;
        while (offset < n) offset *= 2;
        Arrays.sort(data, 0, n, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1] - o2[1]);
            }
        });
        for (int i = 0; i < n; i++) {
            int cnt = query(offset, offset + data[i][0]) + 1;
            data[i][2] = cnt;
            update(offset + data[i][0], cnt);
        }

        Arrays.fill(tree, 0);
        Arrays.sort(data, 0, n, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o2[1] - o1[1]);
            }
        });
        for (int i = 0; i < n; i++) {
            int cnt = query(offset, offset + data[i][0]) + 1;
            data[i][3] = cnt;
            update(offset + data[i][0], cnt);
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = Math.max(sum, data[i][2]);
        }
        System.out.println(n - sum + dup);
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

    private static void update(int p, int diff) {
        while (p > 0) {
            tree[p] = Math.max(tree[p], diff);
            p >>= 1;
        }
    }
}
