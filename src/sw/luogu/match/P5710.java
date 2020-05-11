package sw.luogu.match;

import java.util.Scanner;

public class P5710 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int r1 = p1(a) && p2(a) ? 1 : 0;
        int r2 = p1(a) || p2(a) ? 1 : 0;
        int r3 = (!p1(a) && p2(a)) || (p1(a) && !p2(a)) ? 1 : 0;
        int r4 = !p1(a) && !p2(a) ? 1 : 0;
        System.out.println(r1 + " " + r2 + " " + r3 + " " + r4);
    }

    private static boolean p1(int n) {
        return n % 2 == 0;
    }

    private static boolean p2(int n) {
        return n > 4 && n <= 12;
    }
}
