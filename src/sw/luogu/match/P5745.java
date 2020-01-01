package sw.luogu.match;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P5745 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        int[] d = new int[n + 1];
        int i = 0, j = 0, l = 1, sum = 0, max = 0;
        for (int k = 1; k <= n; k++) {
            in.nextToken();
            d[k] = (int) in.nval;
            sum += d[k];
            if (sum > max) {
                if (sum <= m) {
                    max = sum;
                    i = l;
                    j = k;
                    if (sum == m) break;
                } else {
                    while (sum > m) {
                        sum -= d[l];
                        l++;
                    }
                    if (sum > max) {
                        max = sum;
                        i = l;
                        j = k;
                        if (sum == m) break;
                    }
                }
            }
        }
        System.out.println(i + " " + j + " " + max);
    }
}
