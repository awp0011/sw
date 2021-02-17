package sw.luogu.stage6.P2758;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    private static StreamTokenizer in;
    private static char[] nextCharArray() throws Exception {
        in.nextToken();
        return in.sval.toCharArray();
    }

    public static void main(String[] args) throws Exception {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        char[] s1 = nextCharArray();
        char[] s2 = nextCharArray();
        int[][] f = new int[s1.length + 2][s2.length + 2];
        for (int i = 1; i <= s1.length; i++) f[i][0] = i;
        for (int i = 1; i <= s2.length; i++) f[0][i] = i;
        for (int i = 1; i <= s1.length; i++) {
            for (int j = 1; j <= s2.length; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    f[i][j] = f[i - 1][j - 1];
                } else {
                    f[i][j] = Math.min(f[i - 1][j - 1], Math.min(f[i - 1][j], f[i][j - 1])) + 1;
                }
            }
        }
        System.out.println(f[s1.length][s2.length]);
    }
}
