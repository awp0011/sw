package sw.TP2019.M05.P02;

import java.util.Random;
import java.util.Scanner;

public class source {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.next();
        System.out.println(getPI().substring(0, 4));
    }

    private static String getPI() {
        double inCycleCNT = 0, index = 0;
        double pi;
        Random random = new Random();
        while (index < 5000000) {
            double x = random.nextDouble();
            double y = random.nextDouble();
            if (x * x + y * y < 1) inCycleCNT++;
            index++;
        }
        pi = 4 * inCycleCNT / index;
        return pi + "";
    }
}
