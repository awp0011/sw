package sw.TP2019.M07.P02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

import static java.lang.Integer.parseInt;

public class source {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());
        int[][] tc = new int[N][3];
        for (int i = 0; i < N; i++) {
            tc[i][0] = i;
            tc[i][1] = parseInt(br.readLine());
        }
        Arrays.sort(tc, Comparator.comparingInt(s -> s[1]));

        int sum, cnt, next;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (tc[i][2] == 1) continue;
            tc[i][2] = 1;
            if (tc[i][0] == i) continue;
            sum = 0;
            cnt = 0;
            next = tc[i][0];
            while (tc[next][2] != 1) {
                tc[next][2] = 1;
                cnt++;
                sum += tc[next][1];
                next = tc[next][0];
            }
            ans += Math.min(tc[0][1] * (cnt + 2) + tc[i][1] * 2, tc[i][1] * cnt) + sum;

        }
        System.out.println(ans);
    }
}
