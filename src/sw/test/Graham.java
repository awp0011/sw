package sw.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Graham {
    private static final long[][] Ps = new long[100_003][2];
    private static final int[] hull = new int[100_003];

    //private static final ArrayDeque<long[]> convex_hull= new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long fx = 100_000L, fy = 100_000L;
        int index = 0;
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Ps[i][0] = Long.parseLong(st.nextToken());
            Ps[i][1] = Long.parseLong(st.nextToken());
            if (Ps[i][1] < fy || (Ps[i][1] == fy && Ps[i][0] < fx)) {
                fx = Ps[i][0];
                fy = Ps[i][1];
                index = i;
            }
        }
        long x = Ps[1][0], y = Ps[1][1];
        Ps[1][0] = fx;
        Ps[1][1] = fy;
        Ps[index][0] = x;
        Ps[index][1] = y;

        Arrays.sort(Ps, 2, N, (a1, a2) -> cj(Ps[1], a1, Ps[1], a2) > 0 ? 1 : 0);
        index = 3;
        hull[1] = 1;
        hull[2] = 2;
        hull[3] = 3;
        for (int i = 4; i <= N; i++) {
            while (cj(Ps[hull[index - 1]], Ps[hull[index]], Ps[hull[index]], Ps[i]) <= 0) index--;
            hull[++index] = i;
        }

        System.out.println(index);
        // convex_hull.clear();
    }

    private static long cj(long[] a, long[] b, long[] c, long[] d) {
        return (b[0] - a[0]) * (d[1] - c[1]) - (d[0] - c[0]) * (b[1] - a[1]);
    }
}
