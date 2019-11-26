package sw.luogu.match;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P5661 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int N = (int) in.nval;
        int[][] a = new int[N + 1][3];
        int c, p, t, ans = 0;
        for (int i = 0; i < N; i++) {
            in.nextToken();
            c = (int) in.nval;
            in.nextToken();
            p = (int) in.nval;
            in.nextToken();
            t = (int) in.nval;
            if (c == 0) {
                a[i][0] = p;
                a[i][1] = t;
                a[i][2] = t + 45;
                ans += p;
            } else {
                a[i][0] = p;
                a[i][1] = -1;
                a[i][2] = t;
            }
        }

        a[N][1] = Integer.MAX_VALUE;
        System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        Arrays.sort(a, 0, N, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] == o2[2] ? o1[1] - o2[1] : o1[2] - o2[2];
            }
        });
        int i = 0, j;
        while (i < N) {
            if (a[i][1] == -1) {
                j = i + 1;
                while (j <= N) {
                    if (a[j][1] == -1) j++;
                    else if (a[j][1] > a[i][2]) {
                        ans += a[i][0];
                        i++;
                        break;
                    } else {
                        if (a[j][1] != 0 && a[i][2] > a[j][1] && a[i][2] <= a[j][2] && a[i][0] <= a[j][0]) {
                            i++;
                            a[j][1] = 0;
                            break;
                        } else j++;
                    }
                }
            } else i++;
        }
        System.out.println(ans);
    }
}
