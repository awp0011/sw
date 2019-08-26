package sw.pro.PINARY;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long f1 = 1;
        long f2 = 0;
        long f3 = 0;
        for (int i = 0; i < N; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        System.out.println(f3);

    }
}
