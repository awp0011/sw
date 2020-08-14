package sw.luogu.stage5.P1100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int[] number = new int[32];
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) number[i] = 1;
            n >>= 1;
            if (n == 0) break;
        }
        int idx = 16;
        long ans = 0;
        for (int i = 0; i < 32; i++) {
            if (number[(idx + i) % 32] == 1) ans += (1l << i);
        }
        System.out.println(ans);
    }
}
