package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1420 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int max = 0, cnt = 0, pre = -1, next;
        for (int i = 0; i < n; i++) {
            in.nextToken();
            next = (int) in.nval;
            if (next - pre == 1) cnt++;
            else {
                max = Math.max(max, cnt);
                cnt = 1;
            }
            pre = next;
        }
        max = Math.max(max, cnt);
        System.out.println(max);
    }

}
