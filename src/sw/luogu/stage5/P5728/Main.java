package sw.luogu.stage5.P5728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int[][] d = new int[n][4];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                in.nextToken();
                d[i][j] = (int) in.nval;
                d[i][3] += d[i][j];
            }
            if (i > 0) {

                for (int j = i - 1; j >= 0; j--) {
                    int sum = 0;
                    for (int k = 0; k < 3; k++) {
                        int t = Math.abs(d[i][k] - d[j][k]);
                        if (t <= 5) sum += 1;
                    }
                    if (sum == 3 && Math.abs(d[i][3] - d[j][3]) <= 10) cnt++;
                }

            }
        }
        System.out.println(cnt);
    }
}
