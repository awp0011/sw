package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1134 {
    private static final int[] base = new int[]{6, 8, 4, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 1) System.out.println(1);
        else {
            int ans = 1;
            while (n > 0) {
                for (int i = 2; i <= n % 10; i++) {
                    if (i != 5) ans = (ans * i) % 10;
                }
                n /= 5;
                ans = (ans * base[n % 4]) % 10;
            }

            System.out.println(ans);
        }
    }
}
