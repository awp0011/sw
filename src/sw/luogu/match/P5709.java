package sw.luogu.match;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P5709 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int m = (int) in.nval;
        in.nextToken();
        int t = (int) in.nval;
        in.nextToken();
        int s = (int) in.nval;
        if (t == 0) {
            System.out.println(m);
            System.exit(0);
        }
        int cnt = s / t;
        if (cnt * t < s) cnt++;
        if (cnt > m) System.out.println(0);
        else System.out.println(m - cnt);
    }
}
