package sw.luogu.stage5.P5726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int min = 1000, max = -1;
        double tot = 0;
        for (int i = 0; i < n; i++) {
            in.nextToken();
            int t = (int) in.nval;
            tot += t;
            min = Integer.min(min, t);
            max = Integer.max(max, t);
        }
        double ans = (tot-min-max) / (n - 2);
        System.out.println(String.format("%.2f", ans));
    }
}
