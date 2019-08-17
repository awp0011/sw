package sw.luogu;

import java.util.Scanner;

public class P1426 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int X = sc.nextInt();
        double begin = S - X;
        double end = S + X;
        double length = 0;
        double unit = 7.0;
        while (true) {
            if (length >= begin && length <= end) {
                unit *= 0.98;
                if (length + unit > end || length - unit < begin) {
                    System.out.println('y');
                } else {
                    System.out.println('n');
                }
                break;
            }
            unit *= 0.98;
            length += unit;
        }
    }
}
