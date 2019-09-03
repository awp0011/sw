package sw.luogu.stage1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;

public class P1567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = parseInt(br.readLine());
        int p = MAX_VALUE;
        int ans = 0, sum = 0, c;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= len; i++) {
            c = parseInt(st.nextToken());
            if (c > p) {
                sum++;
            } else {
                if (sum > ans) ans = sum;
                sum = 1;
            }
            p = c;
        }
        System.out.println(ans);
    }
}

