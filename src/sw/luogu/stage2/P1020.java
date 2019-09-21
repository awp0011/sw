package sw.luogu.stage2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class P1020 {
    private static final int[] tree = new int[300000];
    private static final int[][] data = new int[100003][2];

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.eolIsSignificant(true);
        int index = 0;
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            int hi = (int) in.nval;
            data[index][0] = index;
            data[index][1] = hi;
            index++;
        }
        Arrays.sort(data, 0, index, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1] == o2[1]) ? (o1[0] - o2[0]) : (o2[1] - o1[1]);
            }
        });
        int offset = 1;
        while (offset < index) offset *= 2;
        for (int i = 0; i < index; i++) {
            update(offset + data[i][0], query(offset, offset + data[i][0]) + 1);
        }
        System.out.println(tree[1]);
        Arrays.sort(data, 0, index, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1] == o2[1]) ? (o2[0] - o1[0]) : (o1[1] - o2[1]);
            }
        });
        Arrays.fill(tree, 0);
        for (int i = 0; i < index; i++) {
            update(offset + data[i][0], query(offset, offset + data[i][0]) + 1);
        }
        System.out.println(tree[1]);
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

