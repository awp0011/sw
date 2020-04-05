package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1888 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int minn = a, maxn = a;
        if (b < minn) minn = b;
        if (c < minn) minn = c;
        if (b > maxn) maxn = b;
        if (c > maxn) maxn = c;
        System.out.println(gcd(minn, maxn) + "/" + gcd(maxn, minn));
    }

    private static int gcd(int a, int b) {
        int aa = a, bb = b;
        while (aa != bb) {
            if (aa > bb) {
                aa = aa - bb;
            } else {
                bb = bb - aa;
            }
        }
        return a / aa;
    }
}
