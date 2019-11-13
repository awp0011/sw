package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1062OTH {

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int k = (int)in.nval;
        in.nextToken();
        int n = (int)in.nval;
        long[] ans = new long[1005];
        int index = 0, offset = 0;
        long base = 1;
        ans[0] = 1;
        while (offset <= n) {
            if (offset == index) {
                base *= k;
                ans[++offset] = base;
                index = 0;
            } else if (base == ans[index]) {
                index = offset;
            } else {
                ans[++offset] = base + ans[index++];
            }
        }
        System.out.println(ans[n - 1]);
    }
}
