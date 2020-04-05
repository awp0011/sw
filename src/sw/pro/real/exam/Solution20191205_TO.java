package sw.pro.real.exam;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Solution20191205_TO {
    private static final int[][] d = new int[20_0005][3];
    private static int W;
    private static int offset;
    private static long[] top = new long[200];
    private static long[] bot = new long[200];

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("E:\\eclipse-workspace\\SW.PRO\\tc\\simple20191205-1.in"));
        long start = System.currentTimeMillis();
        System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = parseInt(st.nextToken());
            int h = parseInt(st.nextToken());
            int n = parseInt(st.nextToken());
            offset = 1;
            while (offset < W) offset *= 2;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                d[i][0] = parseInt(st.nextToken());
                d[i][1] = parseInt(st.nextToken());
                d[i][2] = parseInt(st.nextToken());
            }
            Arrays.sort(d, 0, n, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];
                }
            });
            Arrays.fill(bot, 0);
            long[] swap;
            for (int i = 0; i < n; ) {
                Arrays.fill(top, 0);
                top[0] = d[i][1];
                while (d[i][1] == top[0]) {//同一高度的点一起处理
                    top[offset + d[i][0] - 1] += d[i][2];
                    i++;
                }
                int delta = (int) (top[0] - bot[0]);
                for (int j = 0; j < W; j++) {
                    if (delta >= W) top[j + offset] += bot[1];
                    else top[j + offset] += query(j + offset - delta, j + offset + delta);
                }
                int pos = offset - 1;
                while (pos >= 1) {
                    top[pos] = Math.max(top[pos * 2], top[pos * 2 + 1]);
                    pos--;
                }
                swap = top;
                top = bot;
                bot = swap;
            }
            System.out.println("#" + t + " " + bot[1]);
        }
        System.out.println("TIme:"+(System.currentTimeMillis()-start));
    }


    private static long query(int s, int e) {
        long max = 0;
        if (s < offset) s = offset;
        if (e >= offset + W) e = offset + W - 1;
        while (s <= e) {
            if (s % 2 == 1) max = Math.max(max, bot[s]);
            if (e % 2 == 0) max = Math.max(max, bot[e]);
            s = (s + 1) >> 1;
            e = (e - 1) >> 1;
        }
        return max;
    }
}
