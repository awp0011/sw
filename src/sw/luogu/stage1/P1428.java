package sw.luogu.stage1;

import java.util.Scanner;

public class P1428 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] fish = new int[len + 1];
        fish[0] = Integer.MAX_VALUE;
        for (int i = 1; i <= len; i++) {
            fish[i] = sc.nextInt();
            int cnt = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (fish[i] > fish[j]) cnt++;
            }
            System.out.print(cnt + " ");
        }
        System.out.println();
    }
}
