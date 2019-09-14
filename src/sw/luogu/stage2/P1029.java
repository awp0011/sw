package sw.luogu.stage2;

import java.util.Scanner;

public class P1029 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();
        int Q = sc.nextInt();
        int total = P * Q;
        int size = (int) Math.sqrt(total);
        int ans = 0;
        for (int i = 1; i <= size; i++) {
            if (total % i == 0 && gdc(i, total / i) == P) ans++;
        }
        System.out.println(ans << 1);
    }

    private static int gdc(int n, int m) {
        if (m == 0) return n;
        return gdc(m, n % m);
    }
}
