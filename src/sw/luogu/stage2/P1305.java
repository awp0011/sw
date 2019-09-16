package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1305 {
    private static int n;
    private static char[] tree = new char[100000];
    private static int[] data = new int[26];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());

        for (int i = 0; i < n; i++) {
            System.out.println(i + 1);
            char[] sval = in.readLine().toCharArray();
            int index = sval[0] - 'a';
            if (data[index] == 0) {
                data[index] = 1;
                tree[data[index]] = sval[0];
            }
            if (sval[1] != '*') {
                tree[data[index] * 2] = sval[1];
                data[sval[1] - 'a'] = data[index] * 2;
            }
            if (sval[2] != '*') {
                tree[data[index] * 2 + 1] = sval[2];
                data[sval[2] - 'a'] = data[index] * 2 + 1;
            }
        }
        RLD(1);
    }

    private static void RLD(int r) {
        if (tree[r] == 0) return;
        System.out.print(tree[r]);
        RLD(r * 2);
        RLD(r * 2 + 1);
    }
}
