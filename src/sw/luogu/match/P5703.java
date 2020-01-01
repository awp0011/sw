package sw.luogu.match;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.math.BigInteger;

public class P5703 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        BigInteger n = BigInteger.valueOf((int) in.nval);
        in.nextToken();
        BigInteger m = BigInteger.valueOf((int) in.nval);
        System.out.println(n.multiply(m).toString());
    }
}
