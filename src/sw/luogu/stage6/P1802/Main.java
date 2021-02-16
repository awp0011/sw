package sw.luogu.stage6.P1802;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    private static StreamTokenizer in;
    private static final int[] lose = new int[1003];
    private static final int[] wins = new int[1003];
    private static final int[] used = new int[1003];
    private static final int[] f = new int[1003];

    private static int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws Exception {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        int N = nextInt();
        int X = nextInt();
        for (int i = 1; i <= N; i++) {
            lose[i] = nextInt();
            wins[i] = nextInt();
            used[i] = nextInt();
        }
        for (int i = 1; i <= N; i++) {
            for (int j = X; j >= used[i]; j--) {
                f[j] = Math.max(f[j] + lose[i], f[j - used[i]] + wins[i]);
            }
            for (int j = used[i] - 1; j >= 0; j--) {
                f[j] += lose[i];
            }
        }
        int ans = 0;
        for (int i = 0; i <= X; i++) {
            ans = Math.max(f[i], ans);
        }
        System.out.println(5L * ans);
    }
}
