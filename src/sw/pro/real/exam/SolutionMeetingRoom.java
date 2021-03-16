package sw.pro.real.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class SolutionMeetingRoom {
    /*
   0: 以Ei进行升序排序
   1: 分别二分查找(upperBound)当前会议前，两个会议室可以举行的会议（最后）prve
   2: 不使用会议i，f[0][i] = f[0][i-1],f[1][i] = f[1][i-1]
   3:  使用会议i, f[0][i] = f[0][prev]+v[i](放到会议室1)
                f[1][i] = f[1][prev]+v[i](放到会议室2)
   4:递推公式  (f[0][i],f[1][i])= Max( f[0][i-1]+f[1][i-1],
                                     f[0][prev]+v[i] + f[1][i-1],
                                     f[1][prev]+v[i] + f[0][i-1])
     */

    private static final int[][] d = new int[3003][3];
    private static final int[][] f = new int[2][3003];
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
            int n = nextInt();
            for (int i = 1; i <= n; i++) {
                d[i][0] = nextInt();
                d[i][1] = nextInt();
                d[i][2] = nextInt();

            }
            Arrays.sort(d, 1, n + 1, Comparator.comparingInt(o -> o[1]));
            for (int i = 1; i <= n; i++) {
                int prev = upperBound(d[i][0] - 1, i - 1);
                f[0][i] = f[0][i - 1];
                f[1][i] = f[1][i - 1];
                if (f[0][prev] + d[i][2] + f[1][i - 1] > f[0][i] + f[1][i]) {
                    f[0][i] = f[0][prev] + d[i][2];
                }
                if (f[1][prev] + d[i][2] + f[0][i - 1] > f[0][i] + f[1][i]) {
                    f[0][i] = f[0][i - 1];
                    f[1][i] = f[1][prev] + d[i][2];
                }
            }
            System.out.println("#" + t + " " + (f[0][n] + f[1][n]));
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
