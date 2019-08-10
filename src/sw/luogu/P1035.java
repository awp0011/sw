package sw.luogu;

import java.util.Scanner;

public class P1035 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        double sum = 0;
        int i = 1;
        for (; ; i++) {
            sum += 1.0 / i;
            if (sum > t) break;
        }
        System.out.println(i);
    }
}
