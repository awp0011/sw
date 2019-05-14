package sw.contest.vjudge.POJ1338;

import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final int[] ans = new int[1510];
    private static final int num = 1501;

    public static void main(String[] args) {
        ans[1] = 1;
        int amount_2 = 1;
        int amount_3 = 1;
        int amount_5 = 1;
        for (int i = 2; i < num; i++) {
            ans[i] = min(ans[amount_2] * 2, min(ans[amount_3] * 3, ans[amount_5] * 5));
            if (ans[i] == ans[amount_2] * 2) amount_2++;//2参与了贡献，递增之

            if (ans[i] == ans[amount_3] * 3) amount_3++;
            if (ans[i] == ans[amount_5] * 5) amount_5++;
        }

        Scanner sc = new Scanner(new InputStreamReader(System.in));
        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;
            System.out.println(ans[n]);
        }
    }


    private static int min(int a, int b) {
        return a > b ? b : a;
    }
}