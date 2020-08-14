package sw.luogu.stage5.P2639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    static int[] f = new int[45001];
    static int[] w = new int[10001];
    static int[] c = new int[10001];

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int m = (int) in.nval;
        in.nextToken();
        int n = (int) in.nval;
        for (int i = 1; i <= n; i++) {
            in.nextToken();
            c[i] = (int) in.nval;
            w[i] = c[i];
        }
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= c[i]; j--) {
                if (f[j - c[i]] + w[i] > f[j])
                    f[j] = f[j - c[i]] + w[i];
            }
        }
        System.out.println(f[m]);
    }
}
