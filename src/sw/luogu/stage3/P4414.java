package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P4414 {
    private static int[] p = new int[3];

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        p[0] = (int) in.nval;
        in.nextToken();
        p[1] = (int) in.nval;
        in.nextToken();
        p[2] = (int) in.nval;
        in.nextToken();
        char[] cs = in.sval.toCharArray();

        if ((cs[0] > cs[1] && p[0] < p[1]) || (cs[0] < cs[1] && p[0] > p[1])) swap(0, 1);
        if ((cs[0] > cs[2] && p[0] < p[2]) || (cs[0] < cs[2] && p[0] > p[2])) swap(0, 2);
        if ((cs[1] > cs[2] && p[1] < p[2]) || (cs[1] < cs[2] && p[1] > p[2])) swap(1, 2);
        System.out.println(p[0] + " " + p[1] + " " + p[2]);
    }

    private static void swap(int a, int b) {
        int t = p[a];
        p[a] = p[b];
        p[b] = t;
    }
}
