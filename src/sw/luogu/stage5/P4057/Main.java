package sw.luogu.stage5.P4057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int a = (int) in.nval;
        in.nextToken();
        int b = (int) in.nval;
        in.nextToken();
        int c = (int) in.nval;
        System.out.println(lcm(a,lcm(b,c)));
    }

    static long gdc(long n1, long n2) {
        if (n1 % n2 == 0) return n2;
        return gdc(n2, n1 % n2);
    }

    static long lcm(long n1, long n2) {
        return n1 * n2 / gdc(n1, n2);
    }
}
