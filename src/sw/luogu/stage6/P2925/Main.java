package sw.luogu.stage6.P2925;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    private static StreamTokenizer in;
    private static int[] d, f, s;

    private static int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws Exception {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        int C = nextInt();
        int H = nextInt();
        d = new int[H + 2];
        f = new int[C + 2];
        s = new int[H + 2];
        for (int i = 1; i <= H; i++) {
            d[i] = nextInt();
            s[i] = s[i - 1] + d[i];
        }
        for (int i = 1; i <= H; i++) {
            int bound = Math.max(C - (s[H] - s[i]), d[i]);
            for (int j = C; j >= bound; j--) {
                f[j] = Math.max(f[j], f[j - d[i]] + d[i]);
            }
        }
        System.out.println(f[C]);
    }
}
