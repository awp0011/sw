package sw.luogu.match;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.BitSet;

public class T104630 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        in.nextToken();
        int k = (int) in.nval;
        BitSet sp = new BitSet();
        for (int i = 1; i <= k; i++) {
            in.nextToken();
            sp.set((int) in.nval, true);
        }
        int cur = 0, cnt = 0;
        while (cur < n) {
            cur += m;
            if (sp.get(cur)) m++;
            cnt++;
        }
        System.out.println(cnt);
    }
}
