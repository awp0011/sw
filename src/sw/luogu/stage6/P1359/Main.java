package sw.luogu.stage6.P1359;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
    private static StreamTokenizer in;

    private static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws IOException {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        int n = nextInt();
        int[] f = new int[n + 1];
        Arrays.fill(f, Integer.MAX_VALUE >> 1);
        f[1] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                f[j] = Math.min(f[j],f[i]+ nextInt());
            }
        }
        System.out.println(f[n]);
    }
}
