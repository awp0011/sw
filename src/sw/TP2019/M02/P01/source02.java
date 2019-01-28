package sw.TP2019.M02.P01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class source02 {
    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            int[] X = new int[N + 2];
            int[] Y = new int[N + 2];
            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                X[i] = Integer.parseInt(st.nextToken());
                Y[i] = Integer.parseInt(st.nextToken());
            }

            long ans = 0;
            for (int i = 1; i <= N; i++) {
                int j = i % N + 1;
                ans += (long) X[i] * Y[j] - (long) X[j] * Y[i];
            }
            ans = Math.abs(ans);
            System.out.printf("%d.%d\n", ans >> 1, ans % 2 == 1 ? 5 : 0);
        }
    }
}
