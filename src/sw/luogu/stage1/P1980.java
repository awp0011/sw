package sw.luogu.stage1;

import java.util.Scanner;

public class P1980 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int t = sc.nextInt();
        int total = 0;
        for (int i = 1; i <= s; i++) {
            total += find(i, t);
        }
        System.out.println(total);
    }

    private static int find(int n, int m) {
        int cnt = 0, t;
        do {
            t = n % 10;
            if (t == m) cnt++;
            n /= 10;
        }
        while (n > 0);
        return cnt;
    }
}
