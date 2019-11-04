package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class P1196 {
    private static final StringBuilder ans = new StringBuilder();
    private static final int[] par = new int[30003];
    private static final int[] val = new int[30003];
    private static final int[] size = new int[30003];

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int T = (int) in.nval;
        for (int i = 1; i <= 30000; i++) par[i] = i;
        Arrays.fill(size, 1);
        char cmd;
        int x, y, i, j;
        for (int k = 0; k < T; k++) {
            in.nextToken();
            cmd = in.sval.charAt(0);
            in.nextToken();
            x = (int) in.nval;
            i = find(x);
            in.nextToken();
            y = (int) in.nval;
            j = find(y);
            if (cmd == 'M') union(i, j);
            else ans.append(i == j ? (Math.abs(val[x] - val[y]) - 1) : -1).append('\n');
        }
        System.out.print(ans.toString());
    }


    private static int find(int c) {
        if (par[c] == c) return c;
        int p1 = par[c];
        par[c] = find(par[c]);
        val[c] += val[p1];
        return par[c];
    }

    private static void union(int i, int j) {
        par[i] = j;
        val[i] = size[j];
        size[j] += size[i];
        size[i] = 0;
    }
}
