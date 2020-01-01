package sw.luogu.match;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;

public class P3613 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int q = (int) in.nval;
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        int t, i, j, k;
        for (int l = 0; l < q; l++) {
            in.nextToken();
            t = (int) in.nval;
            in.nextToken();
            i = (int) in.nval;
            in.nextToken();
            j = (int) in.nval;
            HashMap<Integer, Integer> g = map.get(i);
            if (g == null) {
                g = new HashMap();
                map.put(i, g);
            }
            if (t == 1) {
                in.nextToken();
                k = (int) in.nval;
                g.put(j, k);
            } else {
                System.out.println(g.get(j));
            }
        }
    }
}
