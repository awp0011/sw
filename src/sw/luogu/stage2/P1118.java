package sw.luogu.stage2;

import java.util.Scanner;

public class P1118 {
    private static int n, sum, found;
    private static int[][] triangle;
    private static int[] d;
    private static boolean[] u;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sum = sc.nextInt();
        triangle = new int[n + 1][n + 1];
        triangle[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                triangle[i][j] = triangle[i - 1][j] + triangle[i - 1][j - 1];
            }
        }
        d = new int[n + 1];//data
        u = new boolean[n + 1];//isUsed
        dfs(0, 1);
    }

    private static void dfs(int s, int p) {
        if (found == 1) return;
        if (p == n + 1 && s == sum) {
            for (int i = 1; i < n; i++) {
                System.out.print(d[i] + " ");
            }
            System.out.println(d[n]);
            found = 1;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (u[i]) continue;
            u[i] = true;
            d[p] = i;
            if (s + triangle[n][p] * d[p] <= sum) dfs(s + triangle[n][p] * d[p], p + 1);
            u[i] = false;
            d[p] = 0;
            if (found == 1) return;
        }
    }
}
