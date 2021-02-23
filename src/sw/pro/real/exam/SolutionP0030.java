package sw.pro.real.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class SolutionP0030 {
    static StreamTokenizer in;
    static final int MAX = 10000;
    static int[] d = new int[MAX + 5];

    static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws IOException {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        int T = nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = nextInt();
            for (int i = 1; i <= N; i++) d[i] = nextInt();
            d[1] = d[N];
            d[N] = 0;
            int idx = 1, level = 0;
            while (true) {
                int left = idx << 1;
                int right = left + 1;
                int big = d[left] > d[right] ? left : right;

                if (d[idx] < d[big]) {
                    int tmp = d[big];
                    d[big] = d[idx];
                    d[idx] = tmp;
                    idx = big;
                    level++;
                } else {
                    break;
                }
                if ((idx << 1) > MAX || d[idx << 1] == 0) break;
            }
            idx -= (int)Math.pow(level,2);
            System.out.println("#" + tc + " " + level + " " + idx);
            Arrays.fill(d, 0);
        }
    }
}
