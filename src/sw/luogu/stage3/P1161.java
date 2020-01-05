package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.BitSet;

public class P1161 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        //HashMap<Integer, Integer> map = new HashMap<>();
        BitSet bitSet = new BitSet();
        double a;
        int b, c;
        for (int i = 0; i < n; i++) {
            in.nextToken();
            a = in.nval;
            in.nextToken();
            b = (int) in.nval;
            for (int j = 1; j <= b; j++) {
                c = (int) (a * j);
                if (bitSet.get(c)) bitSet.set(c, false);
                else bitSet.set(c);
            }
        }
        System.out.println(bitSet.nextSetBit(0));
    }

}
