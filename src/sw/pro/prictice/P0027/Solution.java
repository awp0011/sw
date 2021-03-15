package sw.pro.prictice.P0027;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;

/*
 * f[i] 为 到i位置，可以安排的最大价值
 * d[i] 不使用，f[i] = f[i-1]
 * d[i] 使用，二分查找到d[i]最后一个可使用的项目 prev，f[i] = f[prev]+d[2]
 * f[i] = Math.max(f[i - 1], f[prev] + d[i][2]);
 * */
public class Solution {
    private static final int[][] d = new int[100003][3];
    private static final long[] f = new long[100003];
    private static int N;

    private static StreamTokenizer in;

    private static void init() {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    }

    private static int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws Exception {
        init();
        int T = nextInt();
        for (int t = 1; t <= T; t++) {
            N = nextInt();
            for (int i = 1; i <= N; i++) {
                d[i][0] = nextInt();
                d[i][1] = nextInt();
                d[i][2] = nextInt();
                f[i] = 0;
            }
            Arrays.sort(d, 1, N + 1, Comparator.comparingInt(o -> o[1]));
            for (int i = 1; i <= N; i++) {

                int prev = upperBound(d[i][0] - 1, i - 1);
                f[i] = Math.max(f[i - 1], f[prev] + d[i][2]);
            }

            System.out.println(f[N]);
        }
    }

    private static int upperBound(int key, int to) {
        int res = 0;
        int l = 0;
        int r = to;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (d[mid][1] > key) r = mid - 1;
            else if (d[mid][1] < key) {
                l = mid + 1;
                res = mid;
            } else {
                res = mid;
                break;
            }
        }
        while (d[res + 1][1] == d[res][1]) res++;
        return res;
    }
}
