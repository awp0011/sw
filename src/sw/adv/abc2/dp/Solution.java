package sw.adv.abc2.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    private static final int[] counters = new int[30];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        counters[0] = 1;
        for (int tc = 1; tc <= T; tc++) {
            String str = in.readLine();
            for (char c : str.toCharArray()) {
                int pos = c - '@';
                counters[pos] += counters[pos - 1];
            }
            System.out.println("#" + tc + " " + counters[26]);
            Arrays.fill(counters, 0);
        }
    }
}
