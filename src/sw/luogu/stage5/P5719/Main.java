package sw.luogu.stage5.P5719;

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
        int k = (int) in.nval;

        double t1 = 0, t2 = 0;
        int cnt1 = 0, cnt2 = 0;
        for (int i = 1; i <= n; i++) {

            if (i % k == 0) {
                t1 += i;
                cnt1++;
            } else {
                t2 += i;
                cnt2++;
            }
        }

        System.out.print(String.format("%.1f", t1 / cnt1));
        System.out.println(String.format(" %.1f", t2 / cnt2));
    }
}
