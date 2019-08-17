package sw.luogu;

import java.util.Scanner;

public class P1149 {
    private static final int[] base = new int[]{6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
    private static final int[] consist = new int[2000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        if (m < 12) System.out.println(0);
        else {
            for (int i = 0; i < 2000; i++) {
                int j = i;
                while (j >= 1) {
                    consist[i] += base[j % 10];
                    j /= 10;
                }
            }
            consist[0] = 6;
            int ans = 0;
            m -= 4;
            for (int i = 0; i < 1000; i++) {
                for (int j = 0; j < 1000; j++) {
                    if (consist[i] + consist[j] + consist[i + j] == m) ans++;
                }
            }
            System.out.println(ans);
        }

    }
}
