package sw.luogu;

import java.util.Scanner;

public class P1089 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] week = new int[15];
        int fee = 0;
        for (int i = 1; i <= 12; i++) {
            week[i] = week[i - 1] + 300 - sc.nextInt();
            if (week[i] < 0) {
                fee = -i;
                break;
            }
            fee += (week[i] / 100) * 100;
            week[i] %= 100;
        }
        if (fee > 0) {
            fee *= 1.2;
            fee += week[12];
        }
        System.out.println(fee);

    }
}
