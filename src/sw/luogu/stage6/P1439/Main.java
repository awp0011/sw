package sw.luogu.stage6.P1439;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    private static StreamTokenizer in;
    private static final int[] f = new int[100003];
    private static final HashMap<Integer, Integer> p1 = new HashMap<>(100003);
    private static final int[] p2 = new int[100003];

    private static int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws Exception {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        int N = nextInt();
        for (int i = 0; i < N; i++) {
            p1.put(nextInt(), i);
        }
        for (int i = 0; i < N; i++) {
            int next = nextInt();
            p2[i] = p1.get(next);
        }
        int ans = 1;
        f[0] = p2[0];

        for (int i = 1; i < N; i++) {
            int pos = Arrays.binarySearch(f, 0, ans, p2[i]);
            if (pos < 0) pos = Math.abs(pos + 1);
            if (pos == ans) ans++;
            f[pos] = p2[i];
        }

        System.out.println(ans);
    }

}
