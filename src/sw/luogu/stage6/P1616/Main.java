package sw.luogu.stage6.P1616;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    private static final int[] t = new int[10002];
    private static final int[] v = new int[10002];
    private static final long[] f = new long[10000002];


    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int T = (int) in.nval;
        in.nextToken();
        int M = (int) in.nval;


        for (int i = 1; i <= M; i++) {
            in.nextToken();
            t[i] = (int) in.nval;
            in.nextToken();
            v[i] = (int) in.nval;
        }

        for (int i = 1; i <= M; i++) {
            for (int j = t[i]; j <= T; j++) {
                f[j] = Math.max(f[j], f[j - t[i]] + v[i]);
            }
        }

        System.out.println(f[T]);
    }
}

