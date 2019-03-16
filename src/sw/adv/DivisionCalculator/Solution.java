package sw.adv.DivisionCalculator;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int[] ans = new int[26];
        int A, B, counter;
        for (int t = 0; t < T; t++) {
            A = sc.nextInt();
            B = sc.nextInt();
            counter = 26;
            for (int i = 0; i < counter; i++) {
                if (A == 0) break;
                A *= 10;
                if (A < B) ans[i] = 0;
                else {
                    ans[i] = A / B;
                    A %= B;
                }
            }
            if (ans[25] > 4) ans[24]++;
            for (int i = 0; i < 25; i++) {
                sb.append(ans[i]);
            }
            System.out.println("#" + t + " 0." + sb.toString());
            sb.setLength(0);
            Arrays.fill(ans, 0);
        }
    }
}
