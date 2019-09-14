package sw.luogu.stage2;

import java.util.Scanner;

public class P1025PRO {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        System.out.println(dfs(1, K, N));
    }

    private static int dfs(int x, int k, int n) {
        if (k == 1) return 1;
        int sum = 0;
        for (int i = x; i <= n / k; i++) sum += dfs(i, k - 1, n - i);
        return sum;
    }
}