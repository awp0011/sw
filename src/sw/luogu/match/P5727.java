package sw.luogu.match;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P5727 {
    public static void main(String[] args) throws Exception {
        int[] d = new int[10000];
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        d[1] = (int) in.nval;
        int i = 1;
        while (d[i] != 1) {
            if (d[i] % 2 == 0) {
                d[i + 1] = d[i] / 2;
            } else {
                d[i + 1] = 1 + d[i] * 3;
            }
            i++;
        }
        while (i > 0) System.out.print(d[i--] + " ");

    }
}
