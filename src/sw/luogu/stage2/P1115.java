package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1115 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int pSum = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            in.nextToken();
            pSum = Math.max(pSum, 0) + (int) in.nval;
            maxSum = Math.max(pSum, maxSum);
        }
        System.out.println(maxSum);
    }

}
