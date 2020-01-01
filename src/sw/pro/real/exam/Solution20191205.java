package sw.pro.real.exam;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Solution20191205 {
    private static final int[][] d = new int[20_0005][3];
    private static int W, H, N, offset;
    private static long[] top = new long[200];
    private static long[] bot = new long[200];
    private static long[] swap;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("E:\\eclipse-workspace\\SW.PRO\\tc\\simple20191205.in"));

        System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int T = (int) in.nval;
        for (int t = 1; t <= T; t++) {
            in.nextToken();
            W = (int) in.nval;
            in.nextToken();
            H = (int) in.nval;
            in.nextToken();
            N = (int) in.nval;
            offset = 1;
            while (offset < W) offset *= 2;
            for (int i = 0; i < N; i++) {
                in.nextToken();
                d[i][0] = (int) in.nval;//wi
                if (d[i][0] > 50) System.out.println(d[i][0]);
                in.nextToken();
                d[i][1] = (int) in.nval;//hi
                in.nextToken();
                d[i][2] = (int) in.nval;//val
            }
            Arrays.sort(d, 0, N, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];
                }
            });
            //init finished
            Arrays.fill(top, 0);
            Arrays.fill(bot, 0);
            top[0] = d[0][1];
            for (int i = 0; i < N; i++) {
                if (d[i][1] == top[0]) {
                    top[offset + d[i][0]] += d[i][2];
                } else {
                    initTop();
                    dp();
                    swap = top;
                    top = bot;
                    bot = swap;
                    Arrays.fill(top, 0);
                    top[0] = d[i][1];
                    i--;
                }
            }
            initTop();
            dp();
            swap = top;
            top = bot;
            bot = swap;
            System.out.println("#" + t + " " + query(0, N));
        }
    }

    private static void initTop() {
        int pos = offset - 1;
        while (pos >= 1) {
            top[pos] = Math.max(top[pos * 2], top[pos * 2 + 1]);
            pos--;
        }
    }

    private static void dp() {
        if (bot[0] == 0) return;
        int delta = (int) (top[0] - bot[0]);
        for (int i = 1; i <= W; i++) update(i, query(i - delta, i + delta));
    }

    private static void update(int pos, long val) {
        int p = pos + offset;
        while (p >= 1) {
            top[p] = Math.max(top[p], val);
            p >>= 1;
        }
    }

    private static long query(int s, int e) {
        long max = 0;
        if (s < 1) s = 1;
        if (e > W) e = W;
        s += offset;
        e += offset;
        while (s <= e) {
            if (s % 2 == 0) max = Math.max(max, bot[s]);
            if (s % 2 == 1) max = Math.max(max, bot[e]);
            s = (s + 1) >> 1;
            e = (e - 1) >> 1;
        }
        return max;
    }
}
