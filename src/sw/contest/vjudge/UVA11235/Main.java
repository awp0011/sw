package sw.contest.vjudge.UVA11235;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {
    private static final int[] ai = new int[100_002];
    private static final int[] ni = new int[100_002];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = parseInt(st.nextToken());
            if (N == 0) break;
            int Q = parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int num = parseInt(st.nextToken());
                if (num < 0) ni[-num]++;
                else ai[num]++;
            }

            for (int i = 0; i < Q; i++) {
                st = new StringTokenizer(br.readLine());
                int n1 = parseInt(st.nextToken());
                int n2 = parseInt(st.nextToken());
                int max = 0;
                for (int j = n1; j <= n2; j++) {
                    max = Math.max(max, j < 0 ? ni[-j] : ai[j]);
                }
                sb.append(max).append('\n');
            }
            System.out.println(sb.toString().substring(0, sb.length() - 1));
            Arrays.fill(ai, 0);
            Arrays.fill(ni, 0);
            sb.setLength(0);
        }
    }
}
