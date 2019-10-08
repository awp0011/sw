package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1062 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long ans = 0, base = 1;
        while (n > 0) {
            if ((n & 1) == 1) ans += base;
            base *= k;
            n >>= 1;
        }
        System.out.println(ans);
    }
}
