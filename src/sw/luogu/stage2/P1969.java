package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1969 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int ans = 0, min = 0, max = 0, prev = 0, curr;
        boolean isUp = true;
        for (int i = 0; i < n; i++) {
            in.nextToken();
            curr = (int) in.nval;
            if (curr > prev) {
                max = curr;
                isUp = true;
            } else if (curr < prev) {
                if (isUp) {
                    ans += max - min;
                    isUp = false;
                }
                min = curr;
            }
            prev = curr;
        }
        if (isUp) ans += max - min;
        System.out.println(ans);
    }

}
