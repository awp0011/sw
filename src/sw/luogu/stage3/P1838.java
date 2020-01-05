package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1838 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int pos;
        int[][] b = new int[4][4];
        for (int i = 0; i < s.length(); i++) {
            pos = s.charAt(i) - '1';
            b[pos / 3][pos % 3] = i % 2 == 0 ? 1 : -1;
        }
        for (int i = 0; i < 3; i++) {
            check(b[i][0] + b[i][1] + b[i][2]);
            check(b[0][i] + b[1][i] + b[2][i]);
        }
        check(b[0][0] + b[1][1] + b[2][2]);
        check(b[0][2] + b[1][1] + b[2][0]);
        System.out.println("drew.");
    }
    private static void check(int n) {
        if (n == 3) {
            System.out.println("xiaoa wins.");
            System.exit(0);
        } else if (n == -3) {
            System.out.println("uim wins.");
            System.exit(0);
        }
    }
}
