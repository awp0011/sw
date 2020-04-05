package sw.luogu.match;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P5739 {
    private static int n, ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ans = 1;
        jc(1);
    }

    private static void jc(int t) {
        if (t > n) System.out.println(ans);
        else {
            ans *= t;
            jc(t + 1);
        }
    }
}
