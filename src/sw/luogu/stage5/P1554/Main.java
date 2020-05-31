package sw.luogu.stage5.P1554;

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
        int m = (int) in.nval;
        long[] cnt = new long[10];
        for (int i = n; i <= m; i++) {
            int x = i;
            while (x > 0) {
                cnt[x % 10]++;
                x /= 10;
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(cnt[i] + " ");
        }

    }
}
