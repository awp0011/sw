package sw.luogu.stage5.P3984;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int T = (int) in.nval;
        int pre = 0, diff;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            in.nextToken();
            int cur = (int) in.nval;
            if (i > 0) {
                diff = cur - pre;
                ans += diff > T ? T : diff;
            }
            pre = cur;
        }
        System.out.println(ans + T);
    }
}
