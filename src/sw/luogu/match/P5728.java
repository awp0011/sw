package sw.luogu.match;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P5728 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int[][] d = new int[n][3];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                in.nextToken();
                d[i][j] = (int) in.nval;
            }
            if (i > 0) {
                int sum = 0;
                for (int j = i - 1; j >= 0; j--) {
                    for (int k = 0; k < 3; k++) {
                        int t = Math.abs(d[i][k] - d[j][k]);
                        if (t <= 5) sum += t;
                        else sum += 100;
                    }

                }
                if (sum <= 10) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
