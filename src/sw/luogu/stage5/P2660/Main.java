package sw.luogu.stage5.P2660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;

public class Main {
    private static long ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        long x =  Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        if (x > y) solve(x, y);
        else solve(y, x);

    }

    private static void solve(long w, long h) {
        long b = (w / h) * h;
        ans += b * 4;
        if (w % h == 0) {
            System.out.println(ans);
            System.exit(0);
        } else {
            solve(h, w - b);
        }
    }
}
