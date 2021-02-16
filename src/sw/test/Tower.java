package sw.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Tower {
    private static StreamTokenizer in;
    private static final int MAX = 100000;
    private static final int MOD = 1_000_000_007;
    private static final int[] stack = new int[MAX];
    private static final int[] d = new int[MAX];

    private static void init() throws IOException {
        //System.setIn(new FileInputStream(""));
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    }

    private static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws IOException {
        init();
        int T = nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int n = nextInt();
            long sum = 0;
            int top = 0;
            for (int i = 1; i <= n; i++) {
                d[i] = nextInt();
                while (top > 0 && d[stack[top]] < d[i]) top--;
                sum += stack[top];
                sum %= MOD;
                stack[++top] = i;
            }
            System.out.println("#" + tc + " " + sum);
        }
    }
}
