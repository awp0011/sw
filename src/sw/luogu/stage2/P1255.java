package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1255 {
    private static final int[][] c = new int[3][1051];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        c[0][1050] = 1;
        c[1][1050] = 1;
        if (n == 0) {
            System.out.println(0);
        } else if (n == 1) {
            System.out.println(1);
        } else {
            int i = 0;
            for (; i <= n - 1; i++) {
                int carry = 0;
                for (int j = 1050; j >= 0; j--) {
                    c[(i + 2) % 3][j] = c[(i) % 3][j] + c[(i + 1) % 3][j] + carry;
                    carry = c[(i + 2) % 3][j] / 10;
                    c[(i + 2) % 3][j] %= 10;
                }
            }
            i %= 3;
            int j = 0;
            StringBuilder ans = new StringBuilder();
            while (j <= 1050 && c[i][j] == 0) j++;
            while (j <= 1050) ans.append(c[i][j++]);
            System.out.println(ans.toString());
        }
    }
}
