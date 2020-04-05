package sw.luogu.match;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;


public class P5662 {
    private static int N;
    private static int mid;
    private static int[][] R;
    private static final HashMap<Integer, Integer> pool = new HashMap<>();

    public static void main(String[] args) throws IOException {
        //long start = System.currentTimeMillis();
        //System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        //System.setIn(new FileInputStream("C:\\Users\\peng0\\Documents\\Downloads\\testdata (10).in"));
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int t = (int) in.nval;
        in.nextToken();
        N = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        int[][] g = new int[t + 1][N + 1];
        R = new int[N + 1][4];
        for (int i = 1; i <= t; i++) {
            for (int j = 1; j <= N; j++) {
                in.nextToken();
                g[i][j] = (int) in.nval;
            }
            if (i > 1) {
                for (int j = 0; j <= N; j++) {
                    R[j][0] = g[i - 1][j];
                    R[j][1] = g[i][j];
                    R[j][2] = R[j][1] - R[j][0];
                    R[j][3] = 0;
                    if (R[j][2] > 0) {
                        if (pool.get(R[j][2]) == null) {
                            pool.put(R[j][2], j);
                            R[j][3] = 1;
                        } else {
                            int prev = pool.get(R[j][2]);
                            if (R[prev][0] > R[j][0]) {
                                R[prev][3] = 0;
                                pool.put(R[j][2], j);
                                R[j][3] = 1;
                            }
                        }
                    }
                }
                pool.clear();
                Arrays.sort(R, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o2[3] == o1[3] ? o2[0] - o1[0] : o2[3] - o1[3];
                    }
                });

                mid = 0;
                find(0, 0, m);
                if (mid > 0) m = mid;
                //System.out.println(i + ":" + (System.currentTimeMillis() - start) + "| " + M);
            }
        }
        System.out.println(m);

    }

    private static void find(int col, int sum, int m) {
        if (R[col][3] == 0) return;
        int cnt = m / R[col][0];
        if (col + 1 == N || R[col + 1][3] == 0) {
            sum += cnt * R[col][1];
            m -= cnt * R[col][0];
            mid = Integer.max(mid, sum + m);
            return;
        }
        int j = 0;
        while (j <= cnt) {
            int fee = j * R[col][0];
            if (fee < m) {
                find(col + 1, sum + j * R[col][1], m - fee);
            } else {
                if (fee == m) mid = Integer.max(mid, sum + j * R[col][1]);
                else find(col + 1, sum, m);
            }
            j++;
        }
    }
}
