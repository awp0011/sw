package sw.luogu.stage4;

import java.util.Scanner;

public class P5708 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double p = 0.5 * (a + b + c);
        System.out.println(String.format("%.1f", Math.sqrt(p * (p - a) * (p - b) * (p - c))));
    }
}
