package sw.luogu.stage4;

import java.util.Scanner;

public class P5714 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double m = sc.nextInt();
        double h = sc.nextDouble();

        double ret = m / (h * h);

        if (ret < 18.5) {
            System.out.println("Underweight");
        } else if (ret < 24) {
            System.out.println("Normal");
        } else {
            System.out.println(roundToSignificantFigures(ret,6));
            System.out.println("Overweight");
        }
    }
    private static double roundToSignificantFigures(double num, int n) {
        if(num == 0) {
            return 0;
        }

        final double d = Math.ceil(Math.log10(num < 0 ? -num: num));
        final int power = n - (int) d;

        final double magnitude = Math.pow(10, power);
        final long shifted = Math.round(num*magnitude);
        return shifted/magnitude;
    }
}
