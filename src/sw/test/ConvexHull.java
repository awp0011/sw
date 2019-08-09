package sw.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Long.parseLong;

public class ConvexHull {
    private static final Data[] a = new Data[100_003];
    private static final int[] ans = new int[100_003];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long mx = 100_000L, my = 100_000L;
        int m = 0;
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i] = new Data(parseLong(st.nextToken()), parseLong(st.nextToken()));
            if (a[i].y < my || a[i].y == my && a[i].x < mx) {
                my = a[i].y;
                mx = a[i].x;
                m = i;
            }
        }
        long xx, yy;
        xx = a[m].x;
        yy = a[m].y;
        a[m].x = a[1].x;
        a[m].y = a[1].y;
        a[1].x = xx;
        a[1].y = yy;

        Arrays.sort(a, 2, N, (a1, a2) -> cj(a[1], a1, a[1], a2) > 0 ? 1 : 0);
        int tot = 3;
        ans[1] = 1;
        ans[2] = 2;
        ans[3] = 3;
        for (int i = 4; i <= N; i++) {
            while (cj(a[ans[tot - 1]], a[ans[tot]], a[ans[tot]], a[i]) <= 0) tot--;
            ans[++tot] = i;
        }

        System.out.println(tot);
    }

    private static long cj(Data a1, Data a2, Data b1, Data b2) {
        return (a2.x - a1.x) * (b2.y - b1.y) - (b2.x - b1.x) * (a2.y - a1.y);
    }

    private static class Data {
        long x, y;

        Data(long l1, long l2) {
            x = l1;
            y = l2;
        }
    }
}
