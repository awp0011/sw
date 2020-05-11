package sw.pro.real.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Scissors {
    private static final int[] paper = new int[1005];
    private static int e, s, n, k;

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int T = (int) in.nval;
        for (int t = 1; t <= T; t++) {
            in.nextToken();
            n = (int) in.nval;
            in.nextToken();
            k = (int) in.nval;
            s = 1_000_000;
            e = 0;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                paper[i] = (int) in.nval;
                if (paper[i] > e) e = paper[i];
                if (paper[i] < s) s = paper[i];
            }
            e = e - s;
            s = 0;
            System.out.println("#" + t + " " + binarySearch());
        }
    }

    private static int binarySearch() {
        int mid ;
        while (s != e) {
            mid = (s + e) >> 1;
            if (isPossible(mid)) e = mid;
            else s = mid + 1;
        }
        return e;
    }

    private static boolean isPossible(int fee) {
        int min = paper[0], max = paper[0], cnt = 0;
        for (int i = 1; i < n; i++) {
            if (paper[i] > max) max = paper[i];
            if (paper[i] < min) min = paper[i];
            if (max - min > fee) {
                cnt++;
                if (cnt > k) return false;
                min = paper[i];
                max = paper[i];
            }
        }
        return true;
    }
}
