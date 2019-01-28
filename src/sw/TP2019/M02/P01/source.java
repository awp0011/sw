package sw.TP2019.M02.P01;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class source {
    private static final int MAX = 100005;
    private static int N;
    private static int[] X = new int[MAX], Y = new int[MAX];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            X[i] = Integer.parseInt(st.nextToken());
            Y[i] = Integer.parseInt(st.nextToken());
        }
        long ans = 0;
        for (int i = 1; i <= N; i++) {
            int j = i % N + 1;
            ans += (long) X[i] * Y[j] - (long) X[j] * Y[i];
        }
        ans = Math.abs(ans);
        System.out.printf("%d.%d\n", ans >> 1, ans % 2 == 0 ? 0 : 5);

    }
}

