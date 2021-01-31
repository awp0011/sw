package sw.luogu.stage5.P1102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int C = (int) in.nval;
        HashMap<Integer, Integer> d = new HashMap<>();
        BitSet e = new BitSet();
        for (int i = 1; i <= n; i++) {
            in.nextToken();
            int a = (int) in.nval;
            if (e.get(a)) d.put(a, d.get(a) + 1);
            else {
                d.put(a, 1);
                e.set(a);
            }
        }
        long ans = 0;
        for (int i : d.keySet()) {
            if (d.containsKey(i + C)) {
                ans += (long) d.get(i) * d.get(i + C);
            }
        }
        BigInteger one = BigInteger.ONE;

        System.out.println(ans);
    }
}
