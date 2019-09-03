package sw.luogu.stage1;

import java.util.Scanner;

public class P1909 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int fee = Integer.MAX_VALUE;
        for (int i = 1; i <= 3; i++) {
            int m = sc.nextInt();
            int p = sc.nextInt();
            int sum = ((t / m) + ((t % m == 0) ? 0 : 1)) * p;
            if (fee > sum) fee = sum;
        }

        System.out.println(fee);

    }
}
