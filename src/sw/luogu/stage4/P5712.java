package sw.luogu.stage4;

import java.util.Scanner;

public class P5712 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        if (cnt > 1) {
            System.out.println("Today, I ate " + cnt + " apples.");
        } else {
            System.out.println("Today, I ate " + cnt + " apple.");
        }
    }
}
