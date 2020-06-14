package sw.luogu.stage5.P1152;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int cnt = n - 1;
        boolean[] f = new boolean[n];
        int pre = 0, cur = 0;
        for (int i = 0; i < n; i++) {
            in.nextToken();
            cur = (int) in.nval;
            if (i > 0) {
                int tmp = sub(pre, cur);
                if (tmp < n && !f[tmp]) {
                    f[tmp] = true;
                    cnt--;
                }
            }
            pre = cur;
        }
        System.out.println(cnt == 0 ? "Jolly" : "Not jolly");
    }

    private static int sub(int a, int b) {
        return Math.abs(Math.abs(a) - Math.abs(b));
    }
}
