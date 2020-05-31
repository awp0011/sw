package sw.luogu.stage5.P1614;

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

        int temp = 0, min = 500000;
        int[] d = new int[n + 3];
        for (int i = 1; i <= n; i++) {
            in.nextToken();
            d[i] = (int) in.nval;
            temp += d[i];
            if (i > m) {
                temp -= d[i - m];
            }
            if (i >= m) {
                min = Integer.min(min, temp);
            }
        }
        System.out.println(min==500000?0:min);
    }
}
