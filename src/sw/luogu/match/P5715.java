package sw.luogu.match;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class P5715 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        int[] a = new int[3];
        in.nextToken();
        a[0] = (int) in.nval;
        in.nextToken();
        a[1] = (int) in.nval;
        in.nextToken();
        a[2] = (int) in.nval;
        Arrays.sort(a);
        System.out.println(a[0] + " " + a[1] + " " + a[2]);
    }
}
