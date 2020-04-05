package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P5534 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        long a1 = (int) in.nval;
        in.nextToken();
        long a2 = (int) in.nval;
        in.nextToken();
        long n = (int) in.nval;
        System.out.println(n * a1 + n * (n - 1) * (a2 - a1) / 2);
    }
}
