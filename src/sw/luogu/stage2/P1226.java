package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1226 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        long b = (long) in.nval;
        in.nextToken();
        long p = (long) in.nval;
        in.nextToken();
        long k = (long) in.nval;
        System.out.printf(String.format("%d^%d mod %d=%d", b, p, k, pow(b, p, k)));
    }

    public static long pow(long b, long p, long k) {
        long r = 1, base = b;
        while (p > 0) {
            if ((p & 1) == 1) {
                r *= base;
                r %= k;
            }
            base *= base;
            base %= k;
            p >>= 1;
        }
        return r%k;
    }
}
