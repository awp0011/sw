package sw.luogu.stage1;

import java.util.Scanner;

public class P1424 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int t = sc.nextInt();
        int sum = 0, weekday = s;
        for (int i = s; i < s + t; i++) {
            ///System.out.println(weekday);
            if ((weekday % 6) == 0) {
                weekday++;
            } else if ((weekday % 7) == 0) {
                weekday = 1;
            } else {
                sum += 250;
                weekday++;
            }
        }System.out.println(sum);
    }
}
