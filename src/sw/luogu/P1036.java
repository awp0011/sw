package sw.luogu;

import java.util.Scanner;

public class P1036 {
    private static final int[] numbs = new int[20];
    private static int n, k, cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            numbs[i] = sc.nextInt();
        }
        cnt = 0;
        sum(0, 0, k);
        System.out.println(cnt);

    }

    private static void sum(int start, int sum, int count) {
        if (count == 0) {
            //System.out.println(sum);
            if (isPrime(sum)) cnt++;
        } else {
            for (int i = start; i < n; i++) {
                sum += numbs[i];
                sum(i + 1, sum, count - 1);
                sum -= numbs[i];
            }
        }
    }

    private static boolean isPrime(int n) {
        int len = (int) Math.sqrt(n);
        for (int i = 2; i <= len; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
