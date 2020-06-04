package sw.luogu.stage5.P5738;

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
        double ans = 0;
        for (int i = 0; i < n; i++) {
            double min = 10, max = 0, sum = 0;
            for (int j = 0; j < m; j++) {
                in.nextToken();
                sum += in.nval;
                min = Math.min(min, in.nval);
                max = Math.max(max, in.nval);
            }
            ans = Math.max(ans, ((sum-min-max)/(m-2)));
        }
        System.out.println(String.format("%.2f",ans));
    }
}
